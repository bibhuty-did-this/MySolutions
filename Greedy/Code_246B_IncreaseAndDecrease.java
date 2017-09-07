import java.util.Scanner;
import java.io.PrintWriter;

public class Code_246B_IncreaseAndDecrease{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        long sum=0;
        for(int i=0;i<n;++i)
            sum+=in.nextInt();

        out.print(sum%n==0?n:n-1);

        out.flush();
        out.close();
    }
}