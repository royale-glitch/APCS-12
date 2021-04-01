def all_substring(binary):
    res = [binary[i: j] for i in range(len(binary))
          for j in range(i + 1, len(binary) + 1)]
    candidates = []
    for i in res:
        zero_count = 0
        one_count = 0
        for j in i:
            if j == "0":
                zero_count += 1
            else:
                one_count += 1
        if zero_count > one_count:
            candidates.append(i)
    return candidates            
                
def find_big(list):
    big = ""
    for i in range(len(list)):
        if(len(big) <= len(list[i])):
            big = list[i]
    return len(big)
    
N = int(input())
binary = str(input())
k = all_substring(binary)
print(find_big(k))    
    
    
