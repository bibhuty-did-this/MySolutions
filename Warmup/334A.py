# 334A : CANDY BAGS
# Prerequisite : Implementation
n=int(raw_input())
first=1
last=n*n
for i in range(n):
    for j in range(n/2):
        print first,last,
        first+=1
        last-=1
    print
