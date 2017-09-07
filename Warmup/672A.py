# 672A : SUMMER CAMP
# Prerequisite : Implementation
n=int(raw_input())
if n<=9: print n
elif 9<n<=189:
    if (n-9)%2==0: print (9+(n-9)/2)%10
    else: print (9+(n-9)//2+1)//10
else:
    if (n-189)%3==0: print (99+(n-189)//3)%10
    elif (n-189)%3==1: print (99+(n-189)//3+1)//100
    else: print ((99+(n-189)//3+1)%100)//10


