# Note:
    # As a python coders you need to know
        # bisect module(for binary searching)
        # how to strip a string properly(for finding palindrome)
    # in order to understand this code

# Import the necessary module
from bisect import bisect_left

# Store the required values in the lookup table and sort them
arr = []
for i in range(999,100,-1):
    for j in range(999,100,-1):
        t = str(i*j)
        if t == t[::-1]:
            arr.append(i*j)
arr.sort()

# Evaluate the answer
for _ in range(int(raw_input())):
    i = bisect_left(arr,int(raw_input()))
    print arr[i-1]


