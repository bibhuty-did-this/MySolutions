import java.math.BigDecimal;
import java.util.Scanner;
import java.io.PrintWriter;

public class Code_697B_Barnicle{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        String s=in.next();
        int index=s.indexOf('e');
        int power=0,size=s.length();
        for(int i=index+1;i<size;++i){
            power*=10;
            power+=s.charAt(i)-'0';
        }


        out.print(new BigDecimal(s.substring(0,index)).multiply(new BigDecimal("10").pow(power)).stripTrailingZeros().toPlainString());


        out.close();
    }
}