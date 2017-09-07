# All we have to do is to store the sum of all the prime numbers till that number in a lookup table

# Function to find prime number
from math import sqrt
def isPrime(n):
    limit=int(sqrt(n))
    i=3
    while i<=limit:
        if n%i==0:return False
        i+=2
    return True

# Code for the lookup table
summations=[]
summations.append(0)
summations.append(0)
summations.append(2)
sum=2
for i in range(3,1000000,2):
    if isPrime(i):
        sum+=i
        summations.append(sum)
        summations.append(sum)
    else:
        summations.append(sum)
        summations.append(sum)

# Dispaly the result
for _ in range(int(raw_input())):
    print summations[int(raw_input())]