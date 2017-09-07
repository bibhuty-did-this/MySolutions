#include<iostream>
#include<cmath>
using namespace std;
int main(){
  int n,total=0;
  cin>>n;
  char c[n];
  cin>>c;
  for(int i=0;i<n;++i){
    if(c[i]=='1')++total;
    else --total;
  }
  cout<<abs(total);
} 
