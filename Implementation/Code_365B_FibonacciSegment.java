import java.util.Scanner;
import java.io.PrintWriter;

public class Code_365B_FibonacciSegment{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        long[] sequnce=new long[n];
        for(int i=0;i<n;sequnce[i++]=in.nextLong());
        int max=2,counter=2;
        for(int i=2;i<n;++i){
            if(sequnce[i]==sequnce[i-1]+sequnce[i-2]) max=Math.max(max,++counter);
            else counter=2;
        }
        out.println(Math.min(max,n));

        out.close();
    }
}