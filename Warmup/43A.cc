#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(){
	int n,count=1,max=1;
	cin>>n;
	string s[n],temp,win;
	for(int i=0;i<n;++i)cin>>s[i];
	if(n==1 || n==2){
		cout<<s[0];
		return 0;
	}	
	sort(s,s+n);
	for(int i=0;i<n-1;++i){
		cout<<s[i];
		if((s[i]==s[i+1]) && (i+1)!=(n-1))++count;	
		else{
			if(count>=max){
				max=count;
				win=s[i-1];
			}
			count=1;
		}
	}
	cout<<win;
}
