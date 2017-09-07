# Store the result in a lookup table using Seive of Erathoses

# Function to check whether the number is prime or not
import math
def isPrime(n):
    i=3
    limit=int(math.sqrt(n))
    while i<=limit:
        if n%i==0:
            return False
        i+=2
    return True

# Storing the prime numbers in a list
primes=[2]
i=0
odd=3
while i<10000:
    if isPrime(odd):
        primes.append(odd)
        i+=1
    odd+=2

# Print the result
for _ in range(int(raw_input())):
    print primes[int(raw_input())-1]

