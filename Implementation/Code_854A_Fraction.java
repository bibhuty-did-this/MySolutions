import java.util.Scanner;
import java.io.PrintWriter;

public class Code_854A_Fraction{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt(),start;
        if(n%2==0)start=n/2-1;
        else start=n/2;
        for(int i=start;i>=1;--i){
            if(gcd(i,n-i)==1){
                out.print(i+" "+(n-i));
                out.close();
                return;
            }
        }

        out.close();
    }
    public static int gcd(int a,int b){
        if(a==0)return b;
        else return gcd(b%a,a);
    }
}