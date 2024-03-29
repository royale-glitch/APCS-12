import os
import sys
import argparse
import time
import signal
import math
import random

# include the netbot src directory in sys.path so we can import modules from it.
robotpath = os.path.dirname(os.path.abspath(__file__))
srcpath = os.path.join(os.path.dirname(robotpath),"src") 
sys.path.insert(0,srcpath)

from netbots_log import log
from netbots_log import setLogLevel
import netbots_ipc as nbipc
import netbots_math as nbmath

robotName = "SuryaV2"


def play(botSocket, srvConf):
    gameNumber = 0  # The last game number bot got from the server (0 == no game has been started)
    
    # Each scan will be this wide in radians (note, math.pi*2 radians is the same as 360 Degrees)
    scanSliceWidth = math.pi 

    while True:
        try:
            # Get information to determine if bot is alive (health > 0) and if a new game has started.
            getInfoReply = botSocket.sendRecvMessage({'type': 'getInfoRequest'})
        except nbipc.NetBotSocketException as e:
            # We are always allowed to make getInfoRequests, even if our health == 0. Something serious has gone wrong.
            log(str(e), "FAILURE")
            log("Is netbot server still running?")
            quit()

        if getInfoReply['health'] == 0:
            # we are dead, there is nothing we can do until we are alive again.
            continue
            
        

        if getInfoReply['gameNumber'] != gameNumber:
            # A new game has started. Record new gameNumber and reset any variables back to their initial state
            gameNumber = getInfoReply['gameNumber']
            log("Game " + str(gameNumber) + " has started. Points so far = " + str(getInfoReply['points']))

            # start every new game in scan mode. No point waiting if we know we have not fired our canon yet.
            currentMode = "scan"
            
            # The distance to the closest bot in each quadrant is stored in this list.
            quadrant = [0, 0, 0, 0]

        try:
            if currentMode == "wait":
                # find out if we already have a shell in the air. We need to wait for it to explode before
                # we fire another shell. If we don't then the first shell will never explode!
                getCanonReply = botSocket.sendRecvMessage({'type': 'getCanonRequest'})
                if not getCanonReply['shellInProgress']:
                    # we are ready to shoot again!
                    currentMode = "scan"

            if currentMode == "scan":          
                scanRadStart = 0
                scanRadEnd = math.pi
                
                while scanRadStart <= scanRadEnd:
                    if scanRadEnd > 2*math.pi:
                        scanRadEnd = 2*math.pi
                    scanReply = botSocket.sendRecvMessage({'type': 'scanRequest', 'startRadians': scanRadStart, 'endRadians': scanRadEnd})
                    necWidth = math.pi/32 if scanReply['distance'] >= 500 else math.pi/16
                    #log('distance: %s' % scanReply['distance'], 'INFO')
                    if scanReply['distance'] != 0 and scanSliceWidth <= necWidth:     
                        fireDirection = scanRadStart + scanSliceWidth / 2
                        fireDirection = nbmath.normalizeAngle(fireDirection)
                        botSocket.sendRecvMessage({'type': 'fireCanonRequest', 'direction': fireDirection, 'distance': scanReply['distance']})                        
                        currentMode = "wait"                        
                    elif scanReply['distance'] != 0 and scanSliceWidth >= necWidth:
                        scanSliceWidth /= 2
                        scanRadEnd = (scanRadStart + scanRadEnd) / 2
                    else:
                        scanRadStart = scanRadEnd
                        scanRadEnd = scanRadStart + scanSliceWidth                    
                    if scanReply['distance'] == 0 and scanSliceWidth <= necWidth:
                        scanSliceWidth *= 2
                    elif currentMode == "wait":
                        break    
                scanSliceWidth = math.pi
                
        except nbipc.NetBotSocketException as e:
            # Consider this a warning here. It may simply be that a request returned
            # an Error reply because our health == 0 since we last checked. We can
            # continue until the next game starts.
            log(str(e), "WARNING")
            continue
            
            '''
                pi/2
            pi        0
               3pi/2            
            '''
        try:

            # turns around before hitting the edge, hopefully
            getLocationReply = botSocket.sendRecvMessage({'type': 'getLocationRequest'})
            xMin = math.pi/2+random.random()*math.pi-math.pi
            xR = xMin if xMin > 0 else 3*math.pi/2+random.random()*math.pi/2
            x = getLocationReply['x']
            y = getLocationReply['y']
            if abs(x-1000) < 300 or abs(y-1000) < 300 or abs(x-1000) > 700 or abs(y-1000) > 300:
                botSocket.sendRecvMessage({'type': 'setSpeedRequest', 'requestedSpeed' : 0})
            #lower x boundary
            if round(getLocationReply['x']) <= srvConf['botRadius'] + 500:
                botSocket.sendRecvMessage({'type' : 'setDirectionRequest', 'requestedDirection' : xR})
                botSocket.sendMessage({'type': 'setSpeedRequest', 'requestedSpeed': 35})
            #upper x boundary
            elif round(getLocationReply['x']) >= srvConf['arenaSize'] - srvConf['botRadius'] - 500:
                botSocket.sendRecvMessage({'type' : 'setDirectionRequest', 'requestedDirection' : math.pi/2+random.random()*math.pi})
                botSocket.sendMessage({'type': 'setSpeedRequest', 'requestedSpeed': 35})
            #lower y boundary
            elif round(getLocationReply['y']) <= srvConf['botRadius'] + 500:
                botSocket.sendRecvMessage({'type' : 'setDirectionRequest', 'requestedDirection' : random.random()*math.pi})
                botSocket.sendMessage({'type': 'setSpeedRequest', 'requestedSpeed': 35})
            #upper y boundary
            elif round(getLocationReply['y']) >= srvConf['arenaSize'] - srvConf['botRadius'] - 500:
                botSocket.sendRecvMessage({'type' : 'setDirectionRequest', 'requestedDirection' : math.pi+random.random()*math.pi})
                botSocket.sendMessage({'type': 'setSpeedRequest', 'requestedSpeed': 35})
            else:
                # variables that are iterated in the while loop
                x = 0
                i = 0

                # ScaredyCat scans all four quadrants and looks for the closest target
                while x < 2.0:

                    # ScaredyCat scans the quadrant starting from x pi to 1/2 more than x. This is a quarter of a circle.
                    # Then , it adds the server's response to the list
                    scanReply = botSocket.sendRecvMessage({'type': 'scanRequest', 'startRadians': math.pi*x, 'endRadians': math.pi*(x + 1.0/2.0)})
                    quadrant[i] = scanReply['distance']
                    x += 1.0/2.0
                    i += 1

                # finds how far the closest enemy is from us (can't be zero)
                minDistance = min(i for i in quadrant if i > 0)

                # finds which quadrant that enemy is in
                moveDirection = quadrant.index(minDistance)

                # move perpendicular to the enemy.
                # ie. if closest enemy is in quadrant 0, it will move in the direction 3pi/4 or 7pi/4
                '''
                      pi/2
                    1   |   0
                 pi ----|----  0
                    2   |   3
                      3pi/2
                '''
                move1 = 5*math.pi/4 + random.random()*math.pi
                move2 = 7*math.pi/4 + random.random()*math.pi
                move3 = move1 if move1 < 2*math.pi else random.random()*math.pi/4
                move4 = move2 if move2 < 2*math.pi else random.random()*3*math.pi/4
                if moveDirection == 0:
                    moveDirection = math.pi * (3.0/4.0) + random.random()*math.pi
                elif moveDirection == 1:
                    moveDirection = move3
                elif moveDirection == 2:
                    moveDirection = move4
                elif moveDirection == 3:
                    moveDirection = math.pi * (1.0/4.0) + random.random()*math.pi

                # Turn in a new direction
                botSocket.sendMessage({'type': 'setDirectionRequest', 'requestedDirection': moveDirection})

                # Request we start accelerating to max speed
                botSocket.sendMessage({'type': 'setSpeedRequest', 'requestedSpeed': 20})

        except nbipc.NetBotSocketException as e:
            # Consider this a warning here. It may simply be that a request returned
            # an Error reply because our health == 0 since we last checked. We can
            # continue until the next game starts.
            log(str(e), "WARNING")
            continue    

            '''
            try:
                # get location data from server
                getLocationReply = botSocket.sendRecvMessage({'type': 'getLocationRequest'})
                scanReply = botSocket.sendRecvMessage({})
                # find the closest corner:
                if getLocationReply['x'] < srvConf['arenaSize'] / 2:
                    cornerX = 0
                else:
                    cornerX = srvConf['arenaSize']

                if getLocationReply['y'] < srvConf['arenaSize'] / 2:
                    cornerY = 0
                else:
                    cornerY = srvConf['arenaSize']

                # find the angle from where we are to the closest corner
                radians = nbmath.angle(getLocationReply['x'], getLocationReply['y'], cornerX, cornerY)

                # Turn in a new direction
                botSocket.sendRecvMessage({'type': 'setDirectionRequest', 'requestedDirection': radians})

                # Request we start accelerating to max speed
                botSocket.sendRecvMessage({'type': 'setSpeedRequest', 'requestedSpeed': 100})

                # log some useful information.
                degrees = str(int(round(math.degrees(radians))))
                log("Requested to go " + degrees + " degress at max speed.", "INFO")

            except nbipc.NetBotSocketException as e:
                # Consider this a warning here. It may simply be that a request returned
                # an Error reply because our health == 0 since we last checked. We can
                # continue until the next game starts.
                log(str(e), "WARNING")
            continue
            '''
##################################################################
# Standard stuff below.
##################################################################


def quit(signal=None, frame=None):
    global botSocket
    log(botSocket.getStats())
    log("Quiting", "INFO")
    exit()


def main():
    global botSocket  # This is global so quit() can print stats in botSocket
    global robotName

    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter)
    parser.add_argument('-ip', metavar='My IP', dest='myIP', type=nbipc.argParseCheckIPFormat, nargs='?',
                        default='127.0.0.1', help='My IP Address')
    parser.add_argument('-p', metavar='My Port', dest='myPort', type=int, nargs='?',
                        default=20010, help='My port number')
    parser.add_argument('-sip', metavar='Server IP', dest='serverIP', type=nbipc.argParseCheckIPFormat, nargs='?',
                        default='127.0.0.1', help='Server IP Address')
    parser.add_argument('-sp', metavar='Server Port', dest='serverPort', type=int, nargs='?',
                        default=20000, help='Server port number')
    parser.add_argument('-debug', dest='debug', action='store_true',
                        default=False, help='Print DEBUG level log messages.')
    parser.add_argument('-verbose', dest='verbose', action='store_true',
                        default=False, help='Print VERBOSE level log messages. Note, -debug includes -verbose.')
    args = parser.parse_args()
    setLogLevel(args.debug, args.verbose)

    try:
        botSocket = nbipc.NetBotSocket(args.myIP, args.myPort, args.serverIP, args.serverPort)
        joinReply = botSocket.sendRecvMessage({'type': 'joinRequest', 'name': robotName}, retries=300, delay=1, delayMultiplier=1)
    except nbipc.NetBotSocketException as e:
        log("Is netbot server running at" + args.serverIP + ":" + str(args.serverPort) + "?")
        log(str(e), "FAILURE")
        quit()

    log("Join server was successful. We are ready to play!")

    # the server configuration tells us all about how big the arena is and other useful stuff.
    srvConf = joinReply['conf']
    log(str(srvConf), "VERBOSE")

    # Now we can play, but we may have to wait for a game to start.
    play(botSocket, srvConf)


if __name__ == "__main__":
    # execute only if run as a script
    signal.signal(signal.SIGINT, quit)
    main()
