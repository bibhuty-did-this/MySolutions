#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;
int main(){
  int n,ans=1;
  cin>>n;
  int a[n],A[n];
  for(int i=0;i<n;++i)cin>>a[i];
  A[0]=1;
  for(int i=1;i<n;++i)
    if(a[i]>=a[i-1]){
      A[i]=1+A[i-1];
      ans=max(ans,A[i]);
    }else A[i]=1;

  cout<<ans;
}
