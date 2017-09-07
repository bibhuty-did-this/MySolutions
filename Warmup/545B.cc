#include<iostream>
using namespace std;
int main(){
  string n,t;
  cin>>n>>t;  
  int len=n.length(),c=0;
  for(int i=0;i<len;++i){
    if(n[i]!=t[i]){
      if(c%2){
	if(n[i]=='1')n[i]='0';
	else n[i]='1';
      }
      ++c;
    }
  }
  if(c%2)cout<<"impossible";
  else cout<<n;
}
