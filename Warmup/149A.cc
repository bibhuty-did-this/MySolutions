#include<iostream>
#include<algorithm>
using namespace std;
int main(){
  int k,a[12],sum=0,min=0;
  cin>>k;
  for(int i=0;i<12;++i)cin>>a[i];
  sort(a,a+12);
  for(int i=11;i>=0;--i){
    if(sum<k){
      sum+=a[i];
      ++min;
    }
    else break;
  }
  if(sum>=k)cout<<min;
  else cout<<"-1";
}
