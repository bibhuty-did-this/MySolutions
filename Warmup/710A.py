# 710A : KING MOVES
# Prerequisite : Implementation

# Algorithm:
    # Check for the corner cases
    # Check for the extreme row cases excluding corner
    # Check for the usual rows and columns
move=raw_input()
if (move[0]=='a' and (move[1]=='1' or move[1]=='8')) or (move[0]=='h' and (move[1]=='1' or move[1]=='8')):print 3
elif (move[0]=='a' and move[1]!='1' and move[1]!='8') or \
        (move[0]=='h' and move[1]!='1' and move[1]!='8') or \
            (move[1] == '1' and move[0] != 'a' and move[0] != 'h') or \
                (move[1] == '8' and move[0] != 'a' and move[0] != 'h'): print 5
else: print 8