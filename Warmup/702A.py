# 702A : MAXIMUM INCREASE
# Prerequisite : Dynamic Programming, Greedy, Implementation
n=int(raw_input())
number=map(int,raw_input().split())
longest=1
now=1
for i in range(1,n):
    if number[i]>number[i-1]:
        now+=1
        if i==n-1:
            longest=max(longest,now)
    else:
        longest=max(longest,now)
        now=1
print longest