# 595A : VITALY AND NIGHT
# Prerequisite : Implementation

n,m=map(int,raw_input().split())
counter=0
for j in range(n):
    floor=map(int,raw_input().split())
    for i in range(0,2*m,2):
        if floor[i] or floor[i+1]:
            counter+=1
print counter
