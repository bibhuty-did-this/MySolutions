# 697A : PINEAPPLE INCIDENT
# Prerequisite : Implementation

t,s,x=map(int,raw_input().split())
even = (x-t)
odd = (x-t-1)

if t==x: print "YES"
elif (even%s==0 and even>0) or (odd%s==0 and odd>0):print "YES"
else: print "NO"