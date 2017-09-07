#include<iostream>
using namespace std;
int main(){
  int a1,a2,c=0,total=0;
  cin>>a1>>a2;
  if(a1==1 && a2==1){
    cout<<0;
    return 0;
  }
  if(a1<=a2)c=1;  
  while(!(a1==2 && a2==1) &&  !(a1==1 && a2==2) && !(a1==2 && a2==2)){
    if(c){
      ++a1;
      a2-=2;
      ++total;;
    }else{
      ++a2;
      a1-=2;
      ++total;
    }    
    if(0<a1<=2 && a2>2)c=1;
    else if(0<a2<=2 && a1>2)c=0;
  }
  
  cout<<total+1;
}
