#include<bits/stdc++.h>

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
//Map
#define Mci map<char,int>
#define Mcc map<char,char>
#define Mii map<int,int>
#define Mic map<int,char>
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
/*inline ll getn(){
	ll sign=1,num;
	char c;
	c=getchar();
	for(;c<'0'||c>'9';c=getchar())if(c=='-')sign=-1;
	for(num=0;(c>='0' && c<='9');c=getchar())num=num*10+c-'0';
	return num*sign;
}*/
//Optimizing array
//for(int* ptrInt = nArray; ptrInt< nArray+n; ptrInt++) *ptrInt=nSomeValue;

//Main
int main(){
	//Fast IO for cin and cout
	 ios_base::sync_with_stdio(false);
	 cin.tie(NULL);
	 //Code
	 int wh=0,bl=0,i=1;
	 char b;
	 Mci m;
	 m.ins(mp('q',9));
	 m.ins(mp('r',5));
	 m.ins(mp('b',3));
	 m.ins(mp('n',3));
	 m.ins(mp('p',1));
	 m.ins(mp('k',0));
	 Mci::it itr;
	 w(i<=64){
		 b=getchar();
		 if(b=='.'){
			 ++i;
			 continue;
		 }else if(b==' '){
			 continue;
		 }else if(isupper(b)){
			 itr=m.find(tolower(b));
			 wh=wh + (*itr).second;
			 ++i;
		 }else if(islower(b)){
			 itr=m.find(b);
			 bl=bl + (*itr).second;
			 ++i;
		 }
	 }
	 if(wh>bl)puts("White");
	 else if(wh<bl)puts("Black");
	 else puts("Draw");
}
