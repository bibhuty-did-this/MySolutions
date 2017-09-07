# All you need to know is the formula for the following
    # Sum of first n natural number : n(n+1)/2
    # Sum of squares of first n natural numbers : n(n+1)(2n+1)/6

for _ in range(int(raw_input())):
    n=long(raw_input())
    print (abs((((n*(n+1))/2)**2)-(n*(n+1)*(2*n+1))/6))

