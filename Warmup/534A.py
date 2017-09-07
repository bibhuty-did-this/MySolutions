# 534A : EXAM
# Prerequisite : Implementation, Constructive Algorithm
n=int(raw_input())
s=""
if n==1 or n==2:
    print '1'
    print '1'
elif n==3:
    print '2'
    print '1 3'
else:
    num=n//2+1
    print n
    for i in range(n):
        if num<=n:
            print num,
            num+=1
        if i<n/2:
            print (i+1),
        if num>=n and i>=n/2: break