#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(){
  int n,I=0,J=0,total=0;
  cin>>n;
  int a[n];
  vector<int> gaps;
  vector<int> repeat;
  for(int i=0;i<n;++i)cin>>a[i];
  sort(a,a+n);
  //for(int i=0;i<n;++i)cout<<a[i]<<" ";
  //cout<<endl;
  for(int i=0;i<n-1;++i){
    int ck = a[i+1]-a[i];
    if(ck==0)repeat.push_back(a[i+1]);
    else if(ck>1)for(int j=1;j<ck;++j)gaps.push_back(a[i]+j);
  }
  int sizeG = gaps.size();
  int sizeR = repeat.size();
  // for(int i=0;i<sizeR;++i)cout<<repeat[i]<<" ";
  // cout<<endl;
  while(I<sizeR && J<sizeG){
    int val=gaps[J]-repeat[I];
    if(val>0){
      total+=val;
      ++J;
      ++I;
    }else ++J;
  };
  int last=a[n-1]+1;
  if(J==sizeG && I!=sizeR){
    while(I<sizeR){
      total+=(last-repeat[I]);
      ++I;
      ++last;
    }
  }
  cout<<total;
}
