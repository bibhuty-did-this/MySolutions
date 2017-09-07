# 233A : PERFECT PERMUTATION
# Prerequisite : Implementation
n=int(raw_input())
if n%2:
    print -1
else:
    odd=1
    even=2
    while odd<=n-1 and even<=n:
        print even,odd,
        odd,even=odd+2,even+2


