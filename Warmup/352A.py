# 352A : JEFF AND DIGITS
# Prerequisite : Implementation
n=int(raw_input())
numbers=map(int,raw_input().split())
sum=sum(numbers)
nine='555555555'
if sum//45 and n-sum//5: print (nine*(sum//45))+('0'*(n-sum//5))
elif n-sum//5: print 0
else: print -1