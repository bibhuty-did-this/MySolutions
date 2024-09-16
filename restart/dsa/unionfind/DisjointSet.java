package restart.dsa.unionfind;

public class DisjointSet {

    public int[] parent;
    public int[] rank;

    public DisjointSet(int size){
        this.parent=new int[size];
        this.rank=new int[size];
        for(int i=0;i<size;++i){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public void union(int a, int b){
        int rootA=find(a);
        int rootB=find(b);

        if(rootA!=rootB){
            if(rank[rootA]>=rank[rootB]) parent[rootB]=rootA;
            else parent[rootA]=rootB;

            if(rank[rootA]==rank[rootB]) ++rank[rootA];
        }
    }
    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
}
