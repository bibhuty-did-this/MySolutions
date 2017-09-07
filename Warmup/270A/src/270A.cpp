#include <bits/stdc++.h>
using namespace std;
int main() {
	int n;
	cin>>n;
	string s[n];
	for(int i=0;i<n;++i){
		double a;
		cin>>a;
		fmod(360/(180-a),1)?s[i]="NO":s[i]="YES";
	}
	for(int i=0;i<n;++i)cout<<s[i]<<endl;
	return 0;
}
