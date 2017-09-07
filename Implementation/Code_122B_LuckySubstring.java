import java.util.Scanner;
import java.io.PrintWriter;

public class Code_122B_LuckySubstring{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        String s=in.next();
        int four=0,seven=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='4')++four;
            else if(s.charAt(i)=='7')++seven;
        }
        if(four>=seven && four>0)out.print(4);
        else if(seven>0)out.print(7);
        else out.print(-1);

        out.flush();
        out.close();
    }
}