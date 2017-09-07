# 38A : ARMY
# Prerequisite : Implementation

# Take the necessary inputs
n=int(raw_input())
years=map(int,raw_input().split())
a,b=map(int,raw_input().split())

# Sum up the necessary years
sum=0
for i in range(a-1,b-1):sum+=years[i]

# Display the result
print sum