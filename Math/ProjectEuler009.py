# a+b+c=n
# a*a + b*b =c*c
# Solve both the equations and find an expression for b containing only n and a
# As n is a constant we have only 1 variable left i.e. a
# Iterating over a we can evaluate both b,c in O(n) time

for _ in range(int(raw_input())):
    n=float(raw_input())
    M = -1
    for a in range(1, int(n / 2)):
        get_b=(n * (n - (2 * a))) / (2 * (n - a))
        if get_b%1==0:
            b = int(get_b)
            c = n - a - b
            if c > b > a:
                M = max(M, a * b * c)
    print int(M)
