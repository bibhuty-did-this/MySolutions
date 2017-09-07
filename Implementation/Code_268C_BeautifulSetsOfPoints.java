import java.util.Scanner;
import java.io.PrintWriter;

public class Code_268C_BeautifulSetsOfPoints{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt(),m=in.nextInt(),limit=Math.min(n,m);
        out.println(limit+1);
        for(int i=0;i<=limit;++i)
            out.println(i+" "+(limit-i));

        out.close();
    }
}