#include<iostream>
using namespace std;
int main(){
  int n,temp,r25=0,r50=0;
  cin>>n;
  int a[n];
  for(int i=0;i<n;++i)cin>>a[i];
  for(int i=0;i<n;++i){
    temp=a[i];
    if(temp==25)++r25;
    else if(temp==50){
      ++r50;
      if(r25)--r25;
      else{
	cout<<"NO";
	return 0;
      }
    }else if(temp==100){
      if(r50){
	--r50;
	if(r25)--r25;
	else{
	  cout<<"NO";
	  return 0;
	}
      }else{
	if((r25-3)>=0)r25-=3;
	else{
	  cout<<"NO";
	  return 0;
	}
      }
    }
  }
  cout<<"YES";
}
