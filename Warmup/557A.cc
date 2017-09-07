#include<iostream>
using namespace std;
int main(){
  int n,f,F,s,S,t,T,a,b,c;
  cin>>n>>f>>F>>s>>S>>t>>T;
  a=f;
  b=s;
  c=t;
  if((a+b+c)==n){
    cout<<a<<" "<<b<<" "<<c;
    return 0;
  }
  while(1){
    if(a<F){
      ++a;
      if((a+b+c)==n)break;
      else continue;
    }
    if(b<S){
      ++b;
      if((a+b+c)==n)break;
      else continue;
    }
    if(c<T){
      ++c;
      if((a+b+c)==n)break;
      else continue;
    }
  }
  cout<<a<<" "<<b<<" "<<c;
}
