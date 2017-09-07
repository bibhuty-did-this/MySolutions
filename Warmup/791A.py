# 791A : BEAR AND BIG BROTHER
# Prerequisite : Implementation
a,b=map(float,raw_input().split())
import math
logVal=math.log(b/a,1.5)
if logVal%1: print int(math.ceil(logVal))
else: print int(logVal+1)