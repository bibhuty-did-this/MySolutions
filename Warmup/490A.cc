#include<iostream>
#include<stack>
#include<cmath>
using namespace std;
int main(){
 stack<int> one,two,three;
 int temp,n;
 cin>>n;
 for(int i=0;i<n;++i){
  cin>>temp;
  if(temp==1)one.push(i+1);
  else if(temp==2)two.push(i+1);
  else three.push(i+1);
 }
 int team=min(min(one.size(),two.size()),min(two.size(),three.size()));
 cout<<team<<endl;
 while(team--){
  cout<<one.top()<<" "<<two.top()<<" "<<three.top()<<endl;
  one.pop();
  two.pop();
  three.pop();
 }
}
