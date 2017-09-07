#include<iostream>
using namespace std;
int main(){
 int n,min=101,sum=0;
 cin>>n;
 int a[n],p[n];
 for(int i=0;i<n;++i){
  cin>>a[i]>>p[i];
  if(min>p[i])min=p[i];
  sum+=(min*a[i]);
 }
 cout<<sum;
}
