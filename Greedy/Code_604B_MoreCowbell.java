import java.util.Scanner;
import java.io.PrintWriter;

public class Code_604B_MoreCowbell{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt(),k=in.nextInt();
        int[] s=new int[n];
        for(int i=0;i<n;s[i++]=in.nextInt());

        int count=2*k-n,max=s[n-1];
        n-=count;
        for(int i=0;i<n/2;++i)
            max=Math.max(max,s[i]+s[n-1-i]);
        out.print(max);

        out.close();
    }
}