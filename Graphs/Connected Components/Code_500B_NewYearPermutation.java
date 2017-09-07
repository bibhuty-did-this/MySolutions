import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class Code_500B_NewYearPermutation{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        int[] p=new int[n];
        for(int i=0;i<n;p[i++]=in.nextInt());
        int[][] A=new int[n][n];
        for(int i=0,j=0;i<n;++i,j=0)
            for(String line=in.next();j<n;A[i][j]=line.charAt(j++)-'0');

        boolean[] visited=new boolean[n];
        for(int i=0;i<n;++i){
            if(!visited[i]){
                visited[i]=true;
                ArrayList<Integer> index=new ArrayList<>();
                index.add(i);
                for(int j=0;j<index.size();++j){
                    int cur=index.get(j);
                    for(int k=0;k<n;++k){
                        if(A[cur][k]==1 && !visited[k]){
                            visited[k]=true;
                            index.add(k);
                        }
                    }
                }
                int[] elements=new int[index.size()];
                for(int j=0;j<index.size();++j)elements[j]=p[index.get(j)];
                Collections.sort(index);
                Arrays.sort(elements);
                for(int j=0;j<index.size();++j)
                    p[index.get(j)]=elements[j];
            }
        }
        for(int i=0;i<n;out.print(p[i++]+" "));
        out.close();
    }
}