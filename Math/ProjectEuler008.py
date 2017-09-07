# Take the necessary inputs and display the output
# Take care of the tricky case when any of the number is 0
for _ in range(int(raw_input())):
    n,k=map(int,raw_input().split())
    number=raw_input()
    allDigits=[]
    Max=-1
    _max=1
    for i in range(k):
        _max*=int(number[i])
    Max=max(Max,_max)
    for i in range(k,n):
        if(int(number[i-k])==0):
            _max=1
            for j in range(k):
                _max *= int(number[i-k+1+j])
            Max = max(Max, _max)
        else:
            _max=(_max/int(number[i-k]))*int(number[i])
            Max = max(Max, _max)
    print Max
