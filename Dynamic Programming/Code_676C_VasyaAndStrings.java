import java.io.PrintWriter;
import java.util.Scanner;

public class Code_676C_VasyaAndStrings{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int n=in.nextInt(),k=in.nextInt();
        String s=in.next();
        int max=0,a=0,b=0;
        for(int i=0,j=0;i<n;++i){
            if(s.charAt(i)=='a')++a;
            else ++b;
            while(j<=i && Math.min(a,b)>k){
                if(s.charAt(j)=='a')--a;
                else --b;
                ++j;
            }
            max=Math.max(max,a+b);
            //out.println(i+" "+a+" "+b+" "+max);
        }
        out.print(max);

        out.close();
    }
}