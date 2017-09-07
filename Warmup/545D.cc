#include<iostream>
#include<algorithm>
using namespace std;
int main(){
  int n,d=0,s=0;
  cin>>n;
  int t[n];
  for(int i=0;i<n;++i)cin>>t[i];
  sort(t,t+n);
  for(int i=0;i<n;++i){
    if(s<=t[i]){
      ++d;
      s+=t[i];
    }
  }
  cout<<d;
}
