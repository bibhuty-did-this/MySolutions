# 714A : MEETING OF OLD FRIENDS
# Prerequisite : Math

# Take the necessary inputs
l1,r1,l2,r2,k=map(long,raw_input().split())

# Evaluate the result and display it
start=max(l1,l2)
end=min(r1,r2)
if start>end: print 0
else:
    if start<=k<=end: print end-start
    else: print end-start+1
