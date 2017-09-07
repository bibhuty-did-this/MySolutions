#include<bits/stdc++.h>
using namespace std;

void Code_780A_AndryushaAndSocks();//Implementation
void Code_625A_GuestFromThePast();//Math, Implementation
void Code_799A_CarrotCakes();//Brute force, Implementation
void Code_222A_ShooshunsAndSequence();//Brute force, Implementation
void Code_336A_VasilyTheBearAndTriangle();//Implementation, Math
void Code_157A_GameOutcome();//Brute Force
void Code_485A_Factory();//Modular Arithematic
void Code_16A_Flag();//Implementation
void Code_382A_KseniaAndPanScales();//Greedy, Implementation
void Code_408A_LineToCashier();//Implementation
void Code_143A_HelpVasilisaTheWise2();//Brute force, Math
void Code_363A_Soroban();//Implementation
void Code_5A_ChatServersOutgoingTraffic();//Implemenatation
void Code_215A_BicycleChain();//Brute Force, Implementation
void Code_259A_LittleElephantAndChess();//Brute Force, Strings
void Code_365A_GoodNumber();//Implementation
void Code_689A_MikeAndCellphone();//Brute Force, Constructive Algorithm
void Code_242A_HeadsOrTails();//Brute Force, Implementation
void Code_355A_VasyaAndDigitalRoot();//Implementation, Constructive Algorithm
void Code_373A_CollectingBeatsIsFun();//Implementation
void Code_108A_PalindromicTimes();//Implementation, Strings
void Code_104A_Blackjack();//Implementation
void Code_505A_MrKitayutasGift();//Brute Force, Implementation, Strings
void Code_248A_Cupboards();//Implementation
void Code_342A_XeniaAndDivisors();//Greedy, Implementation
void Code_841A_GenerousKefa();//Brute Force
void Code_622A_InfiniteSequence();//Implementation, Math
void Code_63A_SinkingShip();//Implementation, Strings, Data Structure
void Code_762A_kthDivisor();//Math, Number Theory
void Code_729A_InterviewWithOleg();//Implementation, String
void Code_32A_Reconnaissance();//Brute Force
void Code_493A_VasyaAndFootball();

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    Code_493A_VasyaAndFootball();

    return 0;
}

inline void Code_32A_Reconnaissance(){
    int n,k,total=0;
    cin>>n>>k;
    int h[n];
    for(int i=0;i<n;++i)cin>>h[i];
    for(int i=0;i<n-1;++i)
        for(int j=i+1;j<n;++j)
            if(abs(h[i]-h[j])<=k)++total;

    cout<<2*total;
}

inline void Code_729A_InterviewWithOleg(){
    int n;
    cin>>n;
    char s[n];
    for(int i=0;i<n;++i)cin>>s[i];

    int i=0;
    while(i<n){
        if(i+2<n && s[i]=='o' && s[i+1]=='g' && s[i+2]=='o'){
            cout<<"***";
            i+=3;
            while(i+1<n && s[i]=='g' && s[i+1]=='o')i+=2;

        }else{
            cout<<s[i];
            ++i;
        }
    }
}

inline void Code_762A_kthDivisor(){
    long long n,k;
    cin>>n>>k;
    deque<long long> divisors;
    double mid=sqrt(n);
    if(!fmod(mid,1)){
        divisors.push_back(mid);
        --mid;
    }

    for(long long i=mid;i>=1;--i){
        if(n%i==0){
            divisors.push_front(i);
            divisors.push_back(n/i);
        }
    }
    /*
    while(!divisors.empty()){
        cout<<divisors.front()<<" ";
        divisors.pop_front();
    }
    cout<<endl;
    */
    if(k>divisors.size())cout<<-1;
    else cout<<divisors[k-1];
}

inline void Code_63A_SinkingShip(){
    int n;
    cin>>n;
    queue<string> captain, rat, woman_children, man;
    while(n--){
        string name,desingnation;
        cin>>name>>desingnation;
        if(desingnation=="woman" || desingnation=="child")
            woman_children.push(name);
        else if(desingnation=="rat")rat.push(name);
        else if(desingnation=="captain")captain.push(name);
        else man.push(name);
    }
    while(!rat.empty()){
        cout<<rat.front()<<endl;
        rat.pop();
    }
    while(!woman_children.empty()){
        cout<<woman_children.front()<<endl;
        woman_children.pop();
    }
    while(!man.empty()){
        cout<<man.front()<<endl;
        man.pop();
    }
    while(!captain.empty()){
        cout<<captain.front()<<endl;
        captain.pop();
    }

}

inline void Code_622A_InfiniteSequence(){
    long long x;
    cin>>x;
    long long n=((sqrt(8*x+1)-1)/2);
    cout<<(x-(n*(n+1))/2==0?n:x-(n*(n+1))/2);
}

inline void Code_841A_GenerousKefa(){
    int n,k;
    cin>>n>>k;
    int frequency[26];
    memset(frequency,0,sizeof(frequency));
    while(n--){
        char c;
        cin>>c;
        ++frequency[c-'a'];
    }
    for(int i=0;i<26;++i){
        if(frequency[i]<=k)continue;
        else{
            cout<<"NO";
            return;
        }
    }
    cout<<"YES";
}

inline void Code_342A_XeniaAndDivisors(){
    int n;
    cin>>n;
    int one=0,two=0,three=0,four=0,six=0;
    while(n--){
        int num;
        cin>>num;
        if(num==1)++one;
        else if(num==2)++two;
        else if(num==3)++three;
        else if(num==4)++four;
        else if(num==6)++six;
        else{
            cout<<-1;
            return;
        }
    }
    //cout<<one<<" "<<two<<" "<<three<<" "<<four<<" "<<six<<endl;
    if(one!=two+three){
        cout<<-1;
        return;
    }
    if(four>two){
        cout<<-1;
        return;
    }
    if(six<two-four){
        cout<<-1;
        return;
    }
    if(three!=six-(two-four)){
        cout<<-1;
        return;
    }
    //cout<<one<<endl;
    while(one--){
        cout<<1<<" ";
        if(two){
            cout<<2<<" ";
            --two;
            if(four){
                cout<<4;
                --four;
            }else if(six){
                cout<<6;
                --six;
            }
        }else if(three){
            cout<<3<<" "<<6;
            --three;
            --six;
        }
        cout<<endl;
    }

}

inline void Code_248A_Cupboards(){
    int n;
    cin>>n;
    int left=0,right=0;
    for(int i=0;i<n;++i){
        int l,r;
        cin>>l>>r;
        left+=l;
        right+=r;
    }
    cout<<min(left,n-left)+min(right,n-right);
}

inline void Code_505A_MrKitayutasGift(){
    string s,alphabets="abcdefghijklmnopqrstuvwxyz";
    cin>>s;
    int size=s.size();
    for(int i=0;i<size;++i){
        for(int j=0;j<26;++j){
            string temp=s.substr(0,i)+alphabets[j]+s.substr(i);
            int tsize=temp.size(),isOK=true;
            for(int k=0;k<tsize;++k){
                if(temp[k]!=temp[tsize-1-k]){
                    isOK=false;
                    break;
                }
            }
            if(isOK){
                cout<<temp;
                return;
            }
        }
    }
    for(int i=0;i<26;++i){
        string temp=s+alphabets[i];
        int tsize=temp.size(),isOK=true;
        for(int k=0;k<tsize;++k){
            if(temp[k]!=temp[tsize-1-k]){
                isOK=false;
                break;
            }
        }
        if(isOK){
            cout<<temp;
            return;
        }
    }
    cout<<"NA";
}

inline void Code_104A_Blackjack(){
    int n;
    cin>>n;
    n-=10;
    if((n>=1 && n<=9) || n==11)cout<<4;
    else if(n==10)cout<<15;
    else cout<<0;
}

inline void Code_108A_PalindromicTimes(){
     string s;
     cin>>s;
     int hour=(s[0]-'0')*10+(s[1]-'0');
     int min=(s[3]-'0')*10+(s[4]-'0');
     if(min<(hour%10)*10+hour/10 &&
             !(hour>=16 && hour<=19) &&
                !(hour>=6 && hour<=9)){
         if(hour<=9)cout<<0<<hour<<":"<<hour<<0;
         else cout<<hour<<":"<<(hour%10)*10+hour/10;
         return;
     }
     ++hour;
     hour%=24;
     if(hour>=16 && hour<=19)cout<<"20:02";
     else if(hour>=6 && hour<=9)cout<<"10:01";
     else{
        if(hour<=9)cout<<0<<hour<<":"<<hour<<0;
        else cout<<hour<<":"<<(hour%10)<<hour/10;
     }
}

inline void Code_373A_CollectingBeatsIsFun(){
    int k;
    cin>>k;
    k*=2;
    int count[10];
    memset(count,0,sizeof(count));
    for(int i=1;i<=16;++i){
        char c;
        cin>>c;
        if(c=='.')continue;
        ++count[c-'0'];
    }
    bool isOK=true;
    for(int i=1;i<=9;++i){
        if(count[i]>k){
            isOK=false;
            break;
        }
    }
    if(isOK)cout<<"YES";
    else cout<<"NO";

}

inline void Code_355A_VasyaAndDigitalRoot(){
    int k,d;
    cin>>k>>d;
    if(d==0 && k>1){
        cout<<"No solution";
        return;
    }
    --k;
    cout<<d;
    while(k--)cout<<0;
}

inline void Code_242A_HeadsOrTails(){
    int x,y,a,b;
    cin>>x>>y>>a>>b;
    int total=0;
    if(a<=b)a=b+1;
    for(int i=a;i<=x;++i)
        for(int j=b;j<=min(y,i-1);++j)
            ++total;
    cout<<total<<endl;
    for(int i=a;i<=x;++i)
        for(int j=b;j<=min(y,i-1);++j)
            cout<<i<<" "<<j<<endl;
}

inline void Code_689A_MikeAndCellphone(){
    int n;
    cin>>n;
    int number[n];
    for(int i=0;i<n;++i){
        char c;
        cin>>c;
        number[i]=c-'0';
    }
    int positions[10][9]={
        {7,8,9,-1,0,-1,-1,-1,-1},//0
        {-1,-1,-1,-1,1,2,-1,4,5},//1
        {-1,-1,-1,1,2,3,4,5,6},//2
        {-1,-1,-1,2,3,-1,5,6,-1},//3
        {-1,1,2,-1,4,5,-1,7,8},//4
        {1,2,3,4,5,6,7,8,9},//5
        {2,3,-1,5,6,-1,8,9,-1},//6
        {-1,4,5,-1,7,8,-1,-1,0},//7
        {4,5,6,7,8,9,-1,0,-1},//8
        {5,6,-1,8,9,-1,0,-1,-1}//9
    };
    int possibilities=0;
    for(int i=0;i<9;++i){
        bool isOK=true;
        for(int j=0;j<n;++j){
            if(positions[number[j]][i]==-1){
                isOK=false;
                break;
            }
        }
        if(isOK)++possibilities;
    }
    if(possibilities>1)cout<<"NO";
    else cout<<"YES";
}

inline void Code_365A_GoodNumber(){
    int n,k,good=0;
    cin>>n>>k;
    while(n--){
        string number;
        cin>>number;
        int size=number.size();
        bool goodNumber[k+1];
        memset(goodNumber,false,sizeof(goodNumber));
        ++good;
        for(int i=0;i<size;++i)goodNumber[number[i]-'0']=true;
        for(int i=0;i<=k;++i){
            if(!goodNumber[i]){
                --good;
                break;
            }
        }
    }
    cout<<good;
}

inline void Code_259A_LittleElephantAndChess(){
    string WBWBWBWB="WBWBWBWB",BWBWBWBW="BWBWBWBW",row[8];
    for(int i=0;i<8;++i)cin>>row[i];
    for(int i=0;i<8;++i){
        if(row[i]!=WBWBWBWB && row[i]!=BWBWBWBW){
            cout<<"NO";
            return;
        }
    }
    cout<<"YES";
}

inline void Code_215A_BicycleChain(){
    int n;
    cin>>n;
    int a[n];
    for(int i=0;i<n;++i)cin>>a[i];
    int m;
    cin>>m;
    int b[m];
    for(int i=0;i<m;++i)cin>>b[i];
    int maxRatio=0,total=0;
    for(int i=0;i<n;++i)
        for(int j=0;j<m;++j)
            if(b[j]%a[i]==0)
                maxRatio=max(maxRatio,b[j]/a[i]);
    for(int i=0;i<n;++i)
        for(int j=0;j<m;++j)
            if(b[j]%a[i]==0 && b[j]/a[i]==maxRatio)++total;
    cout<<total;
}

inline void Code_5A_ChatServersOutgoingTraffic(){
    string line;
    int users=0,bytes=0;
    while(getline(cin,line)){
        if(line[0]=='+')++users;
        else if(line[0]=='-')--users;
        else bytes+=(line.size()-line.find(':')-1)*users;
    }
    cout<<bytes;
}

inline void Code_363A_Soroban(){
    string s;
    cin>>s;
    int size=s.size();
    for(int i=size-1;i>=0;--i){
        int get=s[i]-'0';
        if(get>=5){
            cout<<"-O|";
            get-=5;
        }else cout<<"O-|";
        for(int i=1;i<=get;++i)cout<<"O";
        cout<<"-";
        for(int i=get+1;i<=4;++i)cout<<"O";
        cout<<endl;
    }
}

inline void Code_143A_HelpVasilisaTheWise2(){
    int r1,r2,c1,c2,d1,d2;
    cin>>r1>>r2>>c1>>c2>>d1>>d2;
    for(int a=1;a<=9;++a){
        int b=r1-a,c=c1-a,d=d1-a;
        if(b<=0 || c<=0 || d<=0 || b>9 || c>9 || d>9)continue;
        if(a==b || a==c || a==d || b==c || b==d || c==d)continue;
        if(b+d!=c2 || c+d!=r2 || b+c!=d2)continue;
        cout<<a<<" "<<b<<endl;
        cout<<c<<" "<<d<<endl;
        return;
    }
    cout<<-1;
}

inline void Code_408A_LineToCashier(){
    int n;
    cin>>n;
    int k[n];
    long long minTime=999999999,counter,get;
    for(int i=0;i<n;++i)cin>>k[i];
    for(int i=0;i<n;++i){
        counter=15*k[i];
        while(k[i]--){
           cin>>get;
           counter+=5*get;
        }
        minTime=min(minTime,counter);
    }
    cout<<minTime;
}

inline void Code_382A_KseniaAndPanScales(){
    string line1,line2;
    cin>>line1>>line2;
    int left=0,right=0,i=0,residual=line2.size(),limit=line1.size();
    while(i<limit && line1[i]!='|'){
        ++left;
        ++i;
    }
    ++i;
    while(i<limit){
        ++right;
        ++i;
    }
    int required=abs(left-right);
    if(residual-required<0 || (residual-required)%2)cout<<"Impossible";
    else{
        if(left<=right){
            cout<<line2.substr(0,required+(residual-required)/2);
            cout<<line1;
            cout<<line2.substr(required+(residual-required)/2);
        }else{
            cout<<line2.substr(required+(residual-required)/2);
            cout<<line1;
            cout<<line2.substr(0,required+(residual-required)/2);
        }
    }
}

inline void Code_16A_Flag(){
    int row,col;
    cin>>row>>col;
    char flag[row][col];
    for(int i=0;i<row;++i)
        for(int j=0;j<col;++j)
            cin>>flag[i][j];
    bool isISO=true;
    for(int j=0;j<col;++j){
        if(flag[0][j]!=flag[0][0]){
            isISO=false;
            break;
        }
    }
    for(int i=1;i<row && isISO;++i){
        if(flag[i-1][0]==flag[i][0]){
            isISO=false;
            break;
        }
        for(int j=0;j<col;++j){
            if(flag[i][j]!=flag[i][0]){
                isISO=false;
                break;
            }
        }
    }
    if(isISO)cout<<"YES";
    else cout<<"NO";
}

inline void Code_485A_Factory(){
    long long a,m;
    cin>>a>>m;
    if(a%m==0){
        cout<<"Yes"<<endl;
        return;
    }
    int limit=log2(m);
    for(int i=1;i<=limit;++i){
        a*=2;
        if(a%m==0){
            cout<<"Yes"<<endl;
            return;
        }
    }
    cout<<"No"<<endl;
}

inline void Code_157A_GameOutcome(){
    int n;
    cin>>n;
    int square[n][n];
    for(int i=0;i<n;++i)
        for(int j=0;j<n;++j)
            cin>>square[i][j];
    int row[n],col[n];
    for(int i=0;i<n;++i){
        row[i]=0;
        for(int j=0;j<n;++j)
            row[i]+=square[i][j];
    }
    for(int j=0;j<n;++j){
        col[j]=0;
        for(int i=0;i<n;++i)
            col[j]+=square[i][j];
    }
    int winning=0;
    for(int i=0;i<n;++i)
        for(int j=0;j<n;++j)
            if(row[i]<col[j])
                ++winning;
    cout<<winning;
}

inline void Code_336A_VasilyTheBearAndTriangle(){
    long x,y;
    cin>>x>>y;
    if(x>0 && y>0)cout<<0<<" "<<x+y<<" "<<x+y<<" "<<0;
    else if(x>0 && y<0)cout<<0<<" "<<y-x<<" "<<x-y<<" "<<0;
    else if(x<0 && y<0)cout<<x+y<<" "<<0<<" "<<0<<" "<<x+y;
    else if(x<0 && y>0)cout<<x-y<<" "<<0<<" "<<0<<" "<<y-x;
}

inline void Code_222A_ShooshunsAndSequence(){
    int n,k;
    cin>>n>>k;
    int a[n+1];
    for(int i=1;i<=n;++i)cin>>a[i];
    int pivot=a[k],operations=0;
    for(int i=k;i<=n;++i){
        if(a[i]!=pivot){
            cout<<"-1";
            return;
        }
    }
    for(int i=k-1;i>=1;--i){
        if(a[i]!=pivot){
            operations=i;
            break;
        }
    }
    cout<<operations;
}

inline void Code_799A_CarrotCakes(){
    int n,t,k,d;
    cin>>n>>t>>k>>d;
    int withoutOven=(n%k==0?t*(n/k):t*(n/k+1));
    if(d+t>=withoutOven)cout<<"NO";
    else cout<<"YES";

}

inline void Code_625A_GuestFromThePast(){
    long long int n,a,b,c,netCost;
    cin>>n>>a>>b>>c;
    netCost=b-c;
    if(netCost>=a || n<b)cout<<n/a;
    else cout<<(n-b)/netCost+1+(n-netCost*((n-b)/netCost+1))/a;

}

inline void Code_780A_AndryushaAndSocks(){
    int n;
    cin>>n;
    int x[2*n+1];
    int count[n+1];
    for(int i=0;i<=n;++i)count[i]=0;
    for(int i=1;i<=2*n;++i)cin>>x[i];
    int onTable=0,maxOnTable=0;
    for(int i=1;i<=2*n;++i){
        if(!count[x[i]]){
            ++count[x[i]];
            ++onTable;
            maxOnTable=max(maxOnTable,onTable);
        }else --onTable;
    }
    cout<<maxOnTable;

}
