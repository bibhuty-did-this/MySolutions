#670A : HOLIDAYS
#Prerequisite: Implementation
n=int(raw_input())
atLeast=(n//7)*2
minimum=0
if(n%7==0):maximum=atLeast
elif n%7==1:maximum=atLeast+1
elif n%7==2:maximum=atLeast+2
elif n%7==6:
    maximum=atLeast+2
    minimum=1
else: maximum=atLeast+2
minimum+=atLeast
print minimum,maximum


