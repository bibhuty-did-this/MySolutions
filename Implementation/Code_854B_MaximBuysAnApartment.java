import java.util.Scanner;
import java.io.PrintWriter;

public class Code_854B_MaximBuysAnApartment{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt(),k=in.nextInt();
        if(k==0)out.print("0 0");
        else out.print(Math.min(1,n-k)+" "+Math.min(2*(k-1)+2,n-k));

        out.close();
    }
}