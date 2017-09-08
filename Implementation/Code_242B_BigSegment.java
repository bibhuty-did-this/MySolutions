import java.util.Scanner;
import java.io.PrintWriter;

public class Code_242B_BigSegment{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int[] l=new int[n];
        int[] r=new int[n];
        for(int i=0;i<n;++i){
            l[i]=in.nextInt();
            r[i]=in.nextInt();
            min=Math.min(min,l[i]);
            max=Math.max(max,r[i]);
        }
        //out.println(min+" "+max);
        int i=0;
        while(i<n){
            if(l[i]<=min && max<=r[i]){
                out.print(i+1);
                out.close();
                return;
            }
            ++i;
        }
        out.print(-1);

        out.close();
    }
}