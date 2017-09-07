import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Vector;

public class Code_264A_EscapeFromStones{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        String s=in.next();
        Vector<Integer> left=new Vector<>();
        Vector<Integer> right=new Vector<>();
        int n=s.length();
        for(int i=1;i<=n;++i){
            if(s.charAt(i-1)=='l') left.add(i);
            else right.add(i);
        }
        for(int r:right)out.println(r);
        for(int i=left.size()-1;i>=0;i--)
            out.println(left.get(i));

        out.close();
    }
}