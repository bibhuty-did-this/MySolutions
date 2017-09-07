# 735A : OSTAP AND GRASSHOPPER
# Prerequisite : Implementation,String
n, k = map(int, raw_input().split())
s = raw_input()
index = int(s.find('G'))
length = int(s.find('T'))
if index < length:
    index+=k
    while 1:
        if index<= length:
            if s[index] == 'T':
                print 'YES'
                break
            elif s[index] == '#':
                print 'NO'
                break
            index += k
        else:
            print 'NO'
            break
else:
    index-=k
    while 1:
        if index>= length:
            if s[index] == 'T':
                print 'YES'
                break
            elif s[index] == '#':
                print 'NO'
                break
            index -= k
        else:
            print 'NO'
            break

