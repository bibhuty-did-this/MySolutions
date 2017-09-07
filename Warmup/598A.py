# 598A : TRICKY SUM
# Prerequisite : Math
for i in range(int(input())):
    n=int(input())
    import math
    p=int(math.log(n,2))+1
    print (n*(n+1))/2 - (pow(2,p)-1)*2