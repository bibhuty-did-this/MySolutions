import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code_837A_TextVolume{
    public static void main(String args[]) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        StringTokenizer in=new StringTokenizer(reader.readLine());
        PrintWriter out=new PrintWriter(System.out);
        ArrayList<String> strings=new ArrayList<>();
        while(in.hasMoreTokens())strings.add(in.nextToken());
        int max=0;
        for(String s:strings)max=Math.max(max,countUpperCase(s));
        out.print(max);

        out.close();
    }
    public static int countUpperCase(String s){
        int count=0,size=s.length();
        for(int i=0;i<size;++i)
            if(Character.isUpperCase(s.charAt(i)))
                ++count;
        return count;
    }
}