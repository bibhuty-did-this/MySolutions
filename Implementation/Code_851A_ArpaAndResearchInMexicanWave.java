import java.util.Scanner;
import java.io.PrintWriter;

public class Code_851A_ArpaAndResearchInMexicanWave{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt(),k=in.nextInt(),t=in.nextInt();
        if(t<=k)out.print(t);
        else if(k<t && t<=n)out.print(k);
        else out.print(Math.min(k,n+k-t));

        out.close();
    }
}