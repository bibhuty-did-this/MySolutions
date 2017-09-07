#include<iostream>
using namespace std;
int main(){
	long long n,t,s=0,diff;
	cin>>n>>t;
	long long arr[t+1];
	arr[0]=1;
	for(long long i=1;i<=t;++i){
		cin>>arr[i];
		diff=arr[i]-arr[i-1];
		if(diff>=0)s+=diff;
		else s+=(n+diff);
	}
	cout<<s;
}
