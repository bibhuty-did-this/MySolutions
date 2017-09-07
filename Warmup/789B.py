# 789B : Masha and geometric depression
# Prerequisite : Implementation, Math

# Take the necessary inputs
b1,q,l,m=map(int,raw_input().split())
a=map(int,raw_input().split())
dictionary={}
for a_i in a:
    if a_i>=0:
        dictionary.update({a_i:True})
    else:
        dictionary.update({a_i:True})


# Modular version of b1 and q for clean evaluation and inf variable
mod_b1=abs(b1)
mod_q=abs(q)
inf='inf'

# Case 0: mod_b1>l
if mod_b1>l:
    print 0
# Case 1: b1=0
    # If b1(or 0) is a bad integer then no progression will be written on the board and vice-versa
elif b1 == 0:
    if dictionary.get(b1)!=None: print 0
    else: print inf
# Case 2: q=0
    # Here we need to check for b1(which can be anything) and 0(or b1*(q**(i-1))
    # If 0 is a bad integer then
        # b1 is the only integer in the progression if it is less than l
    # Else we will have infinite number of integer possible
elif q == 0:
    if dictionary.get(0)!=None:
        if dictionary.get(b1)!=None: print 0
        else: print 1
    else: print inf
# Case 3: q=1
    # Here we simply need to check
        # if mod_b1 <= l
        # if b1 is present as bad integer or not
elif q==1:
    if dictionary.get(b1)!=None:print 0
    else:print inf
# Case 4: q=-1
    # Here we need to check
        # if mod_b1<=l
        # if both b1 and b2 present as bad integer or not ...
            # ...as if anyone is absent the result will be inf
elif q==-1:
    if dictionary.get(b1)!=None and dictionary.get((-1*b1))!=None: print 0
    else: print inf
# Case 5: mod_q>1
    # Iterate over every term which is less than l
        # Check if that value is present in the dictionary or not
else:
    total=0
    gp=b1
    while abs(gp)<=l:
        if dictionary.get(gp)==None:total+=1
        gp*=q
    print total


