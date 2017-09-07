# 746A : COMPOTE
# Prerequisite : Implementation,Math

# a:b:c = 1:2:4
a=int(raw_input())
b=int(raw_input())
c=int(raw_input())
counter=0
while a>=1 and b>=2 and c>=4:
    a-=1
    b-=2
    c-=4
    counter+=7
print counter