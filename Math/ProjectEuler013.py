# Big Integers are required for addition
# You need to convert the result to string to print a portion of it
total=0
for _ in range(input()):
    total+=input()
print str(total)[:10]