#include<iostream>
using namespace std;
int main(){
  int n;
  cin>>n;
  if(n==0){
    cout<<"NO";
    return 0;
    
  }
  while(n){
    if(n%10==1)n/=10;
    else if(n%100==14)n/=100;
    else if(n%1000==144)n/=1000;
    else{
      cout<<"NO";
      return 0;
    }
  }
  cout<<"YES";
}
