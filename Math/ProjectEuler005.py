# Algorithm:
    # You have to find the lcm of all the numbers combinedly

# Generate a lookup table
from fractions import gcd
lcm=[]
lcm.append(1)
for i in range(1,41):
    lcm.append(((lcm[i-1]*i)/gcd(lcm[i-1],i)))

# Display the result
for _ in range(int(raw_input())):
    print lcm[int(raw_input())]