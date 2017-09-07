#include<iostream>
#include<algorithm>
using namespace std;
int main(){
  long long int n,total=0;
  cin>>n;
  long long int a[n];
  for(int i=0;i<n;++i)cin>>a[i];
  sort(a,a+n);
  if(n==1){
    cout<<a[0];
    return 0;
  }
  for(long long int i=n-3;i>=0;--i)total+=(a[i]*(i+2));
  total+=(n*(a[n-2]+a[n-1]));
  cout<<total;  
}
