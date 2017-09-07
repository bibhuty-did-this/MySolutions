#include<iostream>
using namespace std;
int main(){
	int n,_h,_m,h,m,w=1,counter=1;
	cin>>n;
	cin>>_h>>_m;
	--n;
	while(n--){
		cin>>h>>m;
		if(h==_h && m==_m)++counter;
		else{
			if(counter>w)w=counter;
			counter=1;
		}
		_h=h;
		_m=m;
	}
	if(counter>w)w=counter;
	cout<<w;
}
