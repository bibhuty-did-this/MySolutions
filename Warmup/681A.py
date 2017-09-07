# 681A : A GOOD CONTEST
# Algorithm:
    # Prerequisite: Implementation
    # Take a variable to see whether Anton crosses the mark or not
    # With every input check for the condition and break if the condition satisfies
    # Print the result
get= False
for x in range(int(input())):
    before,after=map(int,raw_input().split()[1:])
    if 2400<=before<after:get=True
if(get):print 'YES'
else: print 'NO'