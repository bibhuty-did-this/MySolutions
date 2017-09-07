#include<cstdio>
int main(){
	float sum=0;
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;++i){
		float temp;
		scanf("%f",&temp);
		sum=sum+temp;
	}
	printf("%f",sum/n);
}
