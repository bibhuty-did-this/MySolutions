# 499A : WATCHING A MOVIE
# Prerequisite : Implementation

# Algorithm
    # Take the inputs for n and x
    # Initialize a variable to store the previous r value
    # Initialize a variable for total minutes
    # for every l and r:
    #   ~ calculate the number of minutes it can skip before l
    #   ~ calculate the number of minutes it watches the movie
    #   ~ add both the time to total time
    # print the result at the end

n,x=map(int,raw_input().split())
_r=0
total=0
for i in range(n):
    l,r=map(int,raw_input().split())
    total+=(l-1-_r)%x+r-l+1
    _r=r
print total