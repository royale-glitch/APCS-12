T = int(input())
for i in range(T):
    N = int(input())
    DNA = input()
    if "U" in DNA:
        print("Error RNA nucleobases found!")
    else:
        corr = ""
        for j in DNA:
            if j == "A":
                corr += "T"
            elif j == "T":
                corr += "A"
            elif j == "C":
                corr += "G"
            else:
                corr += "C"
        print (corr)        
