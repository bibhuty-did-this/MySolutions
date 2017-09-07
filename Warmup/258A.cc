#include<iostream>
#include<string>
using namespace std;
int main(){
  string n;
  cin>>n;
  int len=n.length(),i;
  for(i=0;i<len-1;++i){
    if(n[i]=='0'){
      n.erase(n.begin()+i);
      break;
    }    
  }
  if(i!=(len-1))cout<<n;
  else{
    n.erase(n.end()-1);
    cout<<n;
  }
}
