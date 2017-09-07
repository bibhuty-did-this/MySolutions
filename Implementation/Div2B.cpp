#include<bits/stdc++.h>
using namespace std;

void Code_841B_Godsend();//Game theory, Math
void Code_263B_Squares();//Greedy, Implementation, Sorting
void Code_485B_ValuableResources();//Brute Force, Greedy
void Code_569B_Inventory();//Greedy
void Code_347B_FixedPoints();//Implementation, Math
void Code_834B_FestiveEvening();//Data Structure, Implementation
void Code_469B_ChatOnline();

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    Code_834B_FestiveEvening();

    return 0;
}

inline void Code_469B_ChatOnline(){

}

inline void Code_834B_FestiveEvening(){
    int n,k;    
    string gate;
    cin>>n>>k;
    cin>>gate;
    int total[26];
    memset(total,0,sizeof(total));
    for(int i=0;i<n;++i){
        int index=gate[i]-'A';
        ++total[index];
        //cout<<index<<" "<<total[index]<<endl;
    }
    int open=0;
    bool present[26];
    memset(present,false,sizeof(present));
    for(int i=0;i<n;++i){
        int index=gate[i]-'A';
        //cout<<total[index]<<endl;
        if(!present[index]){
            ++open;
            present[index]=true;
            //cout<<open<<endl;
        }
        if(open>k){
            cout<<"YES";
            return;
        }
        --total[index];
        if(!total[index]){
            --open;
            //cout<<open<<endl;
        }
    }
    cout<<"NO";
}

inline void Code_347B_FixedPoints(){
    int n,fixed_point=0;
    cin>>n;
    int a[n];
    for(int i=0;i<n;++i){
        cin>>a[i];
        if(a[i]==i)++fixed_point;
    }
    for(int i=0;i<n;++i){
        if(a[i]!=i){
            if(a[a[i]]==i){
                cout<<fixed_point+2;
                return;
            }
        }
    }
    cout<<min(fixed_point+1,n);
}

inline void Code_569B_Inventory(){
    int n;
    cin>>n;
    int a[n];
    for(int i=0;i<n;++i)cin>>a[i];
    bool required[n];
    bool taken[n+1];
    memset(taken, false, sizeof(taken));
    for(int i=0;i<n;++i){
        if(a[i]<=n && !taken[a[i]]){
            taken[a[i]]=true;
            required[i]=false;
        }else required[i]=true;
    }
    stack<int> st;
    for(int i=1;i<=n;++i)
        if(!taken[i])
            st.push(i);
    for(int i=0;i<n;++i){
        if(!required[i])cout<<a[i]<<" ";
        else{
            cout<<st.top()<<" ";
            st.pop();
        }
    }
}

inline void Code_485B_ValuableResources(){
    int n;
    cin>>n;
    int x[n],y[n];
    for(int i=0;i<n;++i){
        cin>>x[i];
        cin>>y[i];
    }
    sort(x,x+n);
    sort(y,y+n);
    int x1=x[0],y1=y[0],x2=x[n-1],y2=y[n-1];
    //(long long) is necessary to take care of formatting
    cout<<(long long)(pow(max(abs(x2-x1),abs(y2-y1)),2));
}

inline void Code_263B_Squares(){
    int n,k;
    cin>>n>>k;
    vector<int> a;
    if(k>n){
        cout<<-1;
        return;
    }
    for(int i=0;i<n;++i){
        int get;
        cin>>get;
        a.push_back(get);
    }
    sort(a.begin(),a.end());
    cout<<a[n-k]<<" "<<a[n-k];
}

inline void Code_841B_Godsend(){
    int n;
    long sum=0;
    cin>>n;
    int a[n];
    bool allEven=true;
    for(int i=0;i<n;++i){
        cin>>a[i];
        sum+=a[i];
        if(a[i]%2)allEven=false;
    }
    if(!(sum%2) && allEven)cout<<"Second";
    else cout<<"First";
}
