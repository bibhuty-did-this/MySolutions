#include<iostream>
#include<cstdio>
using namespace std;
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	cin>>s;
	size_t l=s.length();
	int i=s[l-2]-'0';
	i=i*10+s[l-1]-'0';
	if(i%4)puts("0");
	else puts("4");
}
