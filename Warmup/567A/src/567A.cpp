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
//List
#define Li list<int>
#define Llli list<long long int>
#define Lc list<char>
#define Lf list<float>
//Queue
#define Qi queue<int>
#define Qlli queue<long long int>
#define Qc queue<char>
#define Qf queue<float>
//Set
#define Si set<int>
#define Slli set<long long int>
#define Sc set<char>
#define Sf set<float>
//Stack
#define Ki stack<int>
#define Klli stack<long long int>
#define Kc stack<char>
#define Kf stack<float>
//Vector
#define Vi vector<int>
#define Vlli vector<long long int>
#define Vc vector<char>
#define Vf vector<float>

/*-------------------------Miscllaneous-----------------------------*/
#define rep(i,n) for(int i=0;i<n;++i)
#define f(i,a,n,k) for( int i=a;i<n;i=i+k)
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
#define plli(a) printf("%l64d",a)
#define ps(a) printf("%s",a)
#define p puts
#define pr printf
#define debug(a) cout<<a<<endl
#define w while

#define pb push_back
#define mp make_pair
#define bs binary_search
#define ins insert
#define it iterator

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
	//Fast IO for cin and cout
	 ios_base::sync_with_stdio(false);
	 cin.tie(NULL);
	 //Code
	 int n=getn();
	 int a[n];
	 rep(i,n)a[i]=getn();
	 pr("%d %d\n",a[1]-a[0],a[n-1]-a[0]);
	 f(i,1,n-1,1) pr("%d %d\n",min(a[i]-a[i-1],a[i+1]-a[i]),max(a[i]-a[0],a[n-1]-a[i]));
	 pr("%d %d\n",a[n-1]-a[n-2],a[n-1]-a[0]);
}
