# 404A : VALERA AND X
# Prerequisite : Implementation

# Take the necessary inputs
n=int(raw_input())
matrix=[]
for i in range(n):matrix.append(raw_input())

# Initialize the necessary variables and check element by element
diagonal=matrix[0][0]
other=matrix[0][1]
correct=True
if diagonal!=other:correct=True
else: correct=False
if correct:
    for i in range(n):
        if matrix[i][i] != diagonal or matrix[i][n - 1 - i] != diagonal:
            correct = False
            break
        for j in range(n):
            if j != i and j != n - 1 - i:
                if matrix[i][j] != other:
                    correct = False
                    break

# Display the result
if correct: print 'YES'
else: print 'NO'
