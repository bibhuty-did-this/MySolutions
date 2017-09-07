#include<iostream>
#include<algorithm>
using namespace std;
void swap(int *xp, int *yp){
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
int main(){
  int n,i,j,f=0,l=0,min=0;
  cin>>n;
  int a[n],b[n];
  for(i=0;i<n;++i)cin>>a[i]>>b[i];
  for (i = 0; i < n-1; i++){   
    for (j = 0; j < n-i-1; j++){ 
      if (a[j] > a[j+1]){
	swap(&a[j],&a[j+1]);
	swap(&b[j],&b[j+1]);
      }
    }
  }
  for(i=0;i<n;++i){
    if(a[i]==a[i+1] && (i!=(n-1)))++l;
    else{
      if(l>f)sort(b+f,b+l+1);
      l=i+1;
      f=i+1;
    }
  }
  for(i=0;i<n;++i){
    if(b[i]>=min)min=b[i];
    else min=a[i];
  }
  cout<<min;
}
