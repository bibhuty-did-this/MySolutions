import java.util.Scanner;
import java.io.PrintWriter;

public class Code_468A_24Game{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        if(n<4)out.print("NO");
        else{
            out.println("YES");

            if(n%2==1){
                out.println("5 * 3 = 15");
                out.println("4 * 2 = 8");
                out.println("15 + 8 = 23");
                out.println("23 + 1 = 24");
                for(int i=7;i<=n;i+=2)
                    out.println(i+" - "+(i-1)+" = 1");
                int repeat=(n-5)/2;
                while(repeat-->0)out.println("24 * 1 = 24");
            }else{
                out.println("4 * 3 = 12");
                out.println("12 * 2 = 24");
                out.println("24 * 1 = 24");
                for(int i=6;i<=n;i+=2)
                    out.println(i+" - "+(i-1)+" = 1");
                int repeat=(n-4)/2;
                while(repeat-->0)out.println("24 * 1 = 24");
            }
        }

        out.close();
    }
}