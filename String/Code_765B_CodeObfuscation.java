import java.util.Scanner;
import java.io.PrintWriter;

public class Code_765B_CodeObfuscation{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int[] present=new int[26];
        int current=0;
        String s=in.next();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)-'a'==current)++current;
            else if(s.charAt(i)-'a'<current)continue;
            else{
                out.print("NO");
                out.close();
                break;
            }
        }
        out.print("YES");

        out.close();
    }
}