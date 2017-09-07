import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Code_277A_LearningLanguages{
    /**
     * Union-Find Disjoint Set:
     *  - It is a data structure to keep track of the occurrence of elements in...
     *  ...different sets and also merging different sets together.
     *  - Application of union find includes finding connected component in a graph...
     *  ...and is also used in Kruskal's algorithm
     *  - Time complexity:
     *      + Union(with path compression) : log* n
     *      + Find
     */
    int[] rank,parent;
    int n,totalSets;

    //Constructor
    public Code_277A_LearningLanguages(int n){
        this.n=n;
        rank=new int[n];
        parent=new int[n];
        totalSets=n;
        for(int i=0;i<n;++i)
            parent[i]=i;
    }

    /**
     * Find:
     *  - We are doing path compression here simply by directing...
     *  ...the representative node directly to the representative set
     */
    int find(int element){
        if(parent[element]!=element)
            parent[element]=find(parent[element]);
        return parent[element];
    }

    /**
     * Union:
     *  - We are doing union by rank to minimize the depth of the tree...
     *  ...by putting the tree with lower rank under the tree with higher...
     *  ...rank during merging
     *  - In case we find the rank of both the trees to be same then we...
     *  ...need to increment the rank of any one of them by putting the...
     *  ...other tree under it
     */
    void union(int x,int y){
        int xRoot=find(x),yRoot=find(y);
        if(xRoot==yRoot)return;
        if(rank[xRoot]<rank[yRoot])
            parent[xRoot]=yRoot;
        else if(rank[xRoot]>rank[yRoot])
            parent[yRoot]=xRoot;
        else{
            parent[yRoot]=xRoot;
            rank[xRoot]=rank[xRoot]+1;
        }
        --totalSets;
    }

    int countSets(){
        return totalSets;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt(),cost=0;
        Code_277A_LearningLanguages disjointSets=new Code_277A_LearningLanguages(n);
        ArrayList<Integer>[] list=new ArrayList[m];
        for(int i=0;i<m;++i)list[i]=new ArrayList<>();
        for(int i=0;i<n;++i){
            int size=in.nextInt();
            if(size==0){
                ++cost;
            }
            while(size-->0)
                list[in.nextInt()-1].add(i);
        }
        for(int i=0;i<m;++i)
            if(list[i].size()!=0)
                for(int y : list[i])
                    disjointSets.union(list[i].get(0),y);
        int knowLanguage=(disjointSets.countSets()-cost>0?disjointSets.countSets()-cost-1:0);
        System.out.println(knowLanguage+cost);
    }
}

