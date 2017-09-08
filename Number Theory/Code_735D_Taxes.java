import java.util.Scanner;
import java.io.PrintWriter;

/**
 * New topic learned:
 *  - Goldbach's Conjecture
 */
public class Code_735D_Taxes{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        long n=in.nextLong();
        if(n==2)out.print(1);
        else if(n%2==0)out.print(2);
        else{
            if(isPrime(n))out.print(1);
            else if(isPrime(n-2))out.print(2);
            else out.print(3);
        }

        out.close();
    }
    public static boolean isPrime(long n){
        long limit=(long)Math.sqrt(n);
        for(long i=3;i<=limit;i+=2)
            if(n%i==0)
                return false;
        return true;
    }
}