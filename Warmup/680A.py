# 680A : BEAR AND FIVE CARDS
# Prerequisite : Implementation

t1,t2,t3,t4,t5=(map(int,raw_input().split()))
a=[t1,t2,t3,t4,t5]
a.sort()
a.reverse()
total=sum(a)
final=total
if a[0]==a[1]:
    subtract=a[0]+a[1]
    if a[1]==a[2]:subtract+=a[2]
    final=min(total-subtract,final)
if a[1]==a[2]:
    subtract=a[1]+a[2]
    if a[2]==a[3]:subtract+=a[3]
    final = min(total-subtract, final)
if a[2]==a[3]:
    subtract=a[2]+a[3]
    if a[3]==a[4]:subtract+=a[4]
    final = min(total-subtract, final)
if a[3]==a[4]:
    subtract=(a[3]+a[4])
    final = min(total-subtract, final)
print final

