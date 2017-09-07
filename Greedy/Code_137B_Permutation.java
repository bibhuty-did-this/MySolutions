import java.util.Scanner;
import java.io.PrintWriter;

public class Code_137B_Permutation{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        boolean[] contains=new boolean[n+1];
        int required=0,max=n;
        while(n-->0){
            int get=in.nextInt();
            if(get<=max){
                if(contains[get])++required;
                else contains[get]=true;
            }else ++required;
        }
        out.print(required);

        out.close();
    }
}