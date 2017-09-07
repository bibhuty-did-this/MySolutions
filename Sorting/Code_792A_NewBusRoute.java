import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class Code_792A_NewBusRoute{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        ArrayList<Long> list=new ArrayList<>();
        while(n-->0)list.add(in.nextLong());
        n=list.size();
        Collections.sort(list);
        ArrayList<Long> distances=new ArrayList<>();
        for(int i=1;i<n;++i)
            distances.add(Math.abs(list.get(i)-list.get(i-1)));
        Collections.sort(distances);
        out.print(distances.get(0)+" ");
        int counter=0;
        for(long distance:distances){
            if(distance==distances.get(0))++counter;
            else break;
        }
        out.print(counter);

        out.close();
    }
}