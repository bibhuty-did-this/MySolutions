#include<iostream>
#include<vector>
using namespace std;
int H[50], V[50],h,v,n;
int main(){
	vector<int> vec;
	cin>>n;
	n=n*n;
	for(int i=0;i<n;++i){
		cin>>h>>v;
		if(!H[h] && !V[v]){
			H[h]=1;
			V[v]=1;
			vec.push_back(i+1);
		}
	}
	for(vector<int>::iterator it=vec.begin();it!=vec.end();++it)cout<<*it<<" ";
}
