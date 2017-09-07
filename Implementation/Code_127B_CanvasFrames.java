import java.util.Scanner;
import java.io.PrintWriter;

public class Code_127B_CanvasFrames{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        int[] a=new int[101];
        while(n-->0)++a[in.nextInt()];
        int pairs=0;
        for(int sticks:a)
            pairs+=sticks/2;
        out.print(pairs/2);

        out.close();
    }
}