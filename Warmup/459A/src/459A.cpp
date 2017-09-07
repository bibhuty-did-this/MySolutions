#include<bits/stdc++.h>
using namespace std;
int main(){
	int x1,y1,x2,y2;
	scanf("%d %d %d %d",&x1,&y1,&x2,&y2);
	if(x1==x2){
		if(-1000<=x1+y1-y2 && x1+y1-y2<=1000)printf("%d %d %d %d",x1+y1-y2,y1,x2+y1-y2,y2);
		else printf("%d %d %d %d",x1-y1+y2,y1,x2-y1+y2,y2);
	}else if(y1==y2){
		if(-1000<=y1+x1-x2 && y1+x1-x2<=1000)printf("%d %d %d %d",x1,y1+x1-x2,x2,y2+x1-x2);
		else printf("%d %d %d %d",x1,y1-x1+x2,x2,y2-x1+x2);
	}else if(abs(x2-x1)==abs(y2-y1)){
		printf("%d %d %d %d",x1,y2,x2,y1);
	}else printf("-1");
}
