#include<iostream>
#include<algorithm>
#include<climits>
using namespace std;
int main(){
 int n,m,min=INT_MAX;
 cin>>n>>m;
 int a[m];
 for(int i=0;i<m;++i) cin>>a[i];
 sort(a,a+m);
 for(int i=0;i<=m-n;++i)if((a[i+n-1]-a[i])<min)min=(a[i+n-1]-a[i]);
 cout<<min;
}
