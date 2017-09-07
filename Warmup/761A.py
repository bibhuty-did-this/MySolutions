# 761A : DASHA AND STAIRS
# Prerequisite : Constructive Algorithm, Math
even,odd=map(int,raw_input().split())
if(((odd==even and odd!=0) or odd==even-1 or even==odd-1)): print 'YES'
else: print 'NO'