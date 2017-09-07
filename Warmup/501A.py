# 501A : CONTEST
# Prerequisite : Implementation
a,b,c,d=map(int,raw_input().split())
score=max((3*a)/10,a-((a*c)/250))-max((3*b)/10,b-((b*d)/250))
if score>0:print "Misha"
elif score<0: print "Vasya"
else: print "Tie"
