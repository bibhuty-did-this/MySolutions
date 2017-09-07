#include<iostream>
#include<stack>
#include<cmath>
using namespace std;
int main(){
  long long l;
  int n=-1;
  cin>>l;
  stack<int> s;
  while(l){
    s.push(l%10);
    l/=10;
    ++n;
  }
  while(!s.empty()){
    if(s.top()==9){
      s.pop();
      l+=(pow(10,n)*9);
      --n;
    }else break;
  }
  while(!s.empty()){
    if(s.top()>=5)l+=(pow(10,n)*(9-s.top()));
    else l+=(pow(10,n)*(s.top()));
    s.pop();
    --n;
  }
  cout<<l;
}

