# 757A : GOTTA CATCH EM' ALL!
# Prerequisite : Implementation
string=raw_input()
list={}
list['Code_854B_MaximBuysAnApartment']=0
list['u']=0
list['l']=0
list['b']=0
list['a']=0
list['s']=0
list['r']=0
alphabets=['Code_854B_MaximBuysAnApartment','u','l','b','a','s','r']
double=['u','a']
for c in string:
    if c in alphabets:
        list[c]+=1
for c in double:list[c]//=2
print min(list.values())