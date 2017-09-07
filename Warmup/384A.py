# 384A : CODER
# Prerequisite : Implementation

n=int(raw_input())
if n%2: print (n*n)/2+1
else: print (n*n)/2
for i in range(n):
    s=''
    if i%2==0:
        for j in range(n):
            if(j%2==0):s+='C'
            else: s+='.'
    else:
        for j in range(n):
            if(j%2==0):s+='.'
            else: s+='C'
    print s

