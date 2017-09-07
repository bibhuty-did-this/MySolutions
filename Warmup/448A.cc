#include<iostream>
using namespace std;
int main(){
	int a1,a2,a3,a,b1,b2,b3,b,n,s;
	cin>>a1>>a2>>a3>>b1>>b2>>b3>>n;
	a=(a1+a2+a3-1)/5 + 1;
	b=(b1+b2+b3-1)/10 + 1;
	if(!(a1+a2+a3))a=0;
	if(!(b1+b2+b3))b=0;
	if((a+b)<=n)cout<<"YES";
	else cout<<"NO";
}
