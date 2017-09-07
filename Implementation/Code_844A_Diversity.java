import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class Code_844A_Diversity{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        String s=in.next();
        int n=s.length(),k=in.nextInt();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<n;set.add(s.charAt(i++)));
        if(n-set.size()>=k-set.size())out.print(Math.min(n-set.size(),Math.max(0,k-set.size())));
        else out.print("impossible");

        out.close();
    }
}