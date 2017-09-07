#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(){
  int n,idx=-1;
  long long int a;
  int  num[60];
  cin>>n>>a;
  for(int i=1;i<=n;++i){
    int temp=a%10;
    if(temp==2||temp==3||temp==5||temp==7)num[++idx]=temp;
    else if(temp==4){
      num[++idx]=2;
      num[++idx]=2;
      num[++idx]=3;
    }else if(temp==6){
      num[++idx]=5;
      num[++idx]=3;
    }else if(temp==8){
      num[++idx]=2;
      num[++idx]=2;
      num[++idx]=2;
      num[++idx]=7;
    }else if(temp==9){
      num[++idx]=3;
      num[++idx]=3;
      num[++idx]=2;
      num[++idx]=7;
    }
    a/=10;
  }
  a=0;
  sort(num,num+idx+1);
  for(int i=idx;i>=0;--i)cout<<num[i];
}
