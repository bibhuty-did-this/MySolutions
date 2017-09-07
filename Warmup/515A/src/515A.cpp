#include<bits/stdc++.h>
using namespace std;
//Fast IO of integers
inline int getn(){
	int sign=1,num;
	char c;
	c=getchar();
	for(;c<'0'||c>'9';c=getchar())if(c=='-')sign=-1;
	for(num=0;(c>='0' && c<='9');c=getchar())num=num*10+c-'0';
	return num*sign;
}
int main(){
	int a=getn(),b=getn(),s=getn(),sum;
	sum=s-abs(a)+abs(b);
	(s>=0&& s%2==0)?puts("Yes"): puts("No");
}
