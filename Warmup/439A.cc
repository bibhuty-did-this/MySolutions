#include<iostream>
using namespace std;
int main(){
  int n,d,tym,br;
  cin>>n>>d;
  tym=(10*(n-1));
  br=tym;
  int t[n];
  for(int i=0;i<n;++i){
    cin>>t[i];
    tym+=t[i];
  }
  if(tym>d)cout<<"-1";
  else cout<<(d-tym+br)/5;
}
