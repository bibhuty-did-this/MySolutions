import javax.xml.ws.soap.MTOM;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class Code_522A_Reposts{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        Set<String> first=new HashSet<>();
        Set<String> second=new HashSet<>();
        Map<String,String> map=new HashMap<>();
        while(n-->0){
            char f[]=in.next().toCharArray();
            String append=in.next();
            char s[]=in.next().toCharArray();
            int sizef=f.length;
            for(int i=0;i<sizef;++i)f[i]=Character.toLowerCase(f[i]);
            int sizes=s.length;
            for(int i=0;i<sizes;++i)s[i]=Character.toLowerCase(s[i]);
            map.put(new String(f),new String(s));
            first.add(new String(f));
            second.add(new String(s));
        }
        first.removeAll(second);
        int max=0;
        for(String start:first){
            int contains=1;
            while(map.containsKey(start)){
                start=map.get(start);
                ++contains;
            }
            max=Math.max(max,contains);
        }
        out.print(max);

        out.close();
    }
}