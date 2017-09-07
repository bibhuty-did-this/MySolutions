#include<iostream>
using namespace std;
int main(){
  long long int n,m,max,min,x,y;
  cin>>n>>m;
  max=((n-m+1)*(n-m))/2;
  x=(((n/m)+1)*(n/m)*(n%m))/2;
  if((n/m)==1)y=0;
  else y=((n/m)*((n/m)-1)*(m-(n%m)))/2;
  min=x+y;
  cout<<min<<" "<<max;
}
