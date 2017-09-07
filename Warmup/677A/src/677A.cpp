#include<iostream>
using namespace std;
int main(){
	int n,h,temp,sum=0;
	cin>>n>>h;
	while(n--){
		cin>>temp;
		if(temp>h)++sum;
		++sum;
	}
	cout<<sum;
}
