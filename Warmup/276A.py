#276A : LUNCH RUSH
# Prerequiaite: Implementation
n,k=map(int,raw_input().split())
maxValue=-1000000000
for i in range(n):
    f,t=map(int,raw_input().split())
    if(t>k):fun=f+k-t
    else: fun=f
    maxValue=max(maxValue,fun)
print maxValue
