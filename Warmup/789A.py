# 789A : Anastasia and pebbles
# Prerequisite : Greedy, Implementation, Math
# Algorithm :
    # Find the total number of pockets to be used
    # The result can be calculated accordingly

# Take the necessary inputs
n,k=map(int,raw_input().split())
pebbles=map(int,raw_input().split())

# Evaluate the result
pocket=0
for currentPebble in pebbles:
    pocket+=int(currentPebble/k)
    if currentPebble%k!=0:
        pocket+=1

# Print the result
if pocket%2!=0:
    print int(pocket/2)+1
else:
    print int(pocket/2)