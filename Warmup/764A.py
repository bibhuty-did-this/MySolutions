# 764A : TAYMYR IS CALLING YOU
# Prerequisite : Implementation, Math

#Import the necessary modules
from fractions import gcd

#Take the necessary input
n,m,z=map(int,raw_input().split())

#Evaluate the result
print (z*gcd(n,m))/(n*m)