import java.util.Scanner;
import java.io.PrintWriter;

public class Code_618B_GuessThePermutation{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        int[][] a=new int[n][n];
        for(int i=0;i<n;++i)
            for(int j=0;j<n;++j)
                a[i][j]=in.nextInt();

        int[] permutation=new int[n+1];
        for(int i=0;i<n;++i){
            int[] frequency=new int[n+1];
            for(int j=0;j<n;++j){
                ++frequency[a[i][j]];
            }
            for(int j=n-1;j>=1;--j)
                if(frequency[n-j]==j)
                    permutation[i+1]=n-j;
        }
        for(int i=1;i<=n;++i){
            if(permutation[i]==n-1){
                permutation[i]=n;
                break;
            }
        }
        for(int i=1;i<=n;++i)out.print(permutation[i]+" ");
        out.close();
    }
}