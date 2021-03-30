import random

def print_2D_Array(n):		
    for i in n:
    	for j in i:
    		print(j,end = " ")
    	print()	
    	
def find_Sum(n):
    total = 0
    for i in n:
        for j in i:
            total += j
    print (total)        
            
board = []
for i in range(10):
	temp = []
	for j in range(10):
	    temp.append(random.randrange(0,10))
	board.append(temp)      
            
find_Sum(board)  
print_2D_Array(board)
