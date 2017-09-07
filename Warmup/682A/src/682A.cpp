#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cmath>
#include<vector>
#include<set>
#include<list>
#include<map>
#include<stack>
#include<queue>
#include<deque>
#include<algorithm>

using namespace std;

/*------------------------------Data types in C++-----------------------------*/
#define ll long long

/*--------------------------------Containers----------------------------------*/
//Deque
#define Di deque<int>
#define Dlli deque<long long int>
#define Dc deque<char>
#define Df deque<float>
#define Dd deque<double>
//List
#define Li list<int>
#define Llli list<long long int>
#define Lc list<char>
#define Lf list<float>
#define Ld list<double>
//Queue
#define Qi queue<int>
#define Qlli queue<long long int>
#define Qc queue<char>
#define Qf queue<float>
#define Qd queue<double>
//Set
#define Si set<int>
#define Slli set<long long int>
#define Sc set<char>
#define Sf set<float>
#define Sd set<double>
//Stack
#define Ki stack<int>
#define Klli stack<long long int>
#define Kc stack<char>
#define Kf stack<float>
#define Kd stack<double>
//Vector
#define Vi vector<int>
#define Vlli vector<long long int>
#define Vc vector<char>
#define Vf vector<float>
#define Vd vector<double>
#define Vld vector<long double>

/*-------------------------Miscllaneous-----------------------------*/
#define f(a,n) for( a=0;a<n;++a)
#define fk(a,n,k) for( a=1;a<n;a=a+k)
#define s(a,n)  sort(a,a+n)

#define si(a) scanf("%d",&a)
#define sc(a) scanf("%c",&a)
#define sf(a) scanf("%f",&a)
#define sd(a) scanf("%lf",&a)
#define slli(a) scanf("%l64d",&a)
#define ss(a) scanf("%s",&a)

#define pi(a) printf("%d",a)
#define pc(a) printf("%c",a)
#define pf(a) printf("%f",a)
#define pd(a) printf("%lf",a)
#define plli(a) printf("%lld",a)
#define ps(a) printf("%s",a)
#define p puts
#define debug(a) cout<<a<<endl
#define w while

//Fast IO of integers
inline ll getn(){
	ll sign=1,num;
	char c;
	c=getchar();
	for(;c<'0'||c>'9';c=getchar())if(c=='-')sign=-1;
	for(num=0;(c>='0' && c<='9');c=getchar())num=num*10+c-'0';
	return num*sign;
}
//Optimizing array
//for(int* ptrInt = nArray; ptrInt< nArray+n; ptrInt++) *ptrInt=nSomeValue;

//Main
int main(){
	 ios_base::sync_with_stdio(false);
	 cin.tie(NULL);
	 ll n,m,i=1,temp,count=0,add,total=0;
	 m=getn();//debug(m);
	 n=getn();//debug(n);
	 int div=m/5;
	 int mod=m%5;
	 w(i<6){
		 count=0;
		 temp=5-(i%5);//debug(temp);
		 if(mod){
			 add=1;
			 --mod;
		 } else add=0;
		 w(temp<n+1){
			 temp=temp+5;
			 ++count;
		 }
		 total=total+count*(div+add);
		 ++i;
	 }
	 plli(total);
}
