#include<iostream>
#include<cstring>
#define MAX 100000
using namespace std;

int main(){
  char s[MAX];
  int m_idx=-1,M_idx=-1,test=1;
  cin>>s;
  int len=strlen(s);
  char c=s[len-1];
  for(int i=len-2;i>=0;--i){
    if(s[i]=='2' || s[i]=='4' || s[i]=='6' || s[i]=='8' || s[i]=='0'){
      if(s[i]<c)m_idx=i;
      else if(test){
	M_idx=i;
	test=0;
      }
    }
  }
  char temp=s[len-1];
  if(m_idx!=-1){
    s[len-1]=s[m_idx];
    s[m_idx]=c;
  }else{
    if(M_idx==-1){
      cout<<-1;
      return 0;
    }else{
      s[len-1]=s[M_idx];
      s[M_idx]=c;
    }
  }
  cout<<s;
}
