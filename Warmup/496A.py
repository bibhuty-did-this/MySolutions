# 496A : MINIMUM DIFFICULTY
# Prerequisite: Math, Implementation, Brute Force
n=int(raw_input())
number=map(int,raw_input().split())
difference=number[1]-number[0]
stepDifference=1000000000
for i in range(2,n):
    difference=max(difference,number[i]-number[i-1])
    stepDifference = min(stepDifference, number[i] - number[i - 2])
print max(difference,stepDifference)

