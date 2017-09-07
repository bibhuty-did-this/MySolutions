import java.util.Scanner;
import java.io.PrintWriter;

public class Code_821B_OkabeAndBananaTree{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        long m=in.nextLong(),b=in.nextLong();
        long bananaTrees=0;
        for(long y=0;y<=b;++y){
            long x=(b-y)*m;
            bananaTrees=Math.max(bananaTrees,((x+1)*(y+1)*(x+y))/2);
        }
        out.print(bananaTrees);

        out.flush();
        out.close();
    }
}