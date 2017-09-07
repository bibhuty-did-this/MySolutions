import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class Code_710B_OptimalPointOnALine{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        ArrayList<Integer> list=new ArrayList<>(n);
        for(int i=0;i<n;list.add(in.nextInt()),++i);
        Collections.sort(list);
        out.print(n%2==0?list.get(n/2-1):list.get(n/2));

        out.close();
    }
}