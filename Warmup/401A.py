# 401A : VANYA AND CARDS
# Prerequisite : Implementation, Math
n,x=map(int,raw_input().split())
cards=abs(sum(map(int,raw_input().split())))

if cards: print (cards-1)//x + 1
else: print 0
