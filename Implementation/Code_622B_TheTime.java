import java.util.Scanner;
import java.io.PrintWriter;

public class Code_622B_TheTime{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        String s=in.next();
        int passed=in.nextInt();
        int hour=(s.charAt(0)-'0')*10+(s.charAt(1)-'0')+passed/60;
        passed%=60;
        int minutes=(s.charAt(3)-'0')*10+(s.charAt(4)-'0')+passed;
        hour+=minutes/60;
        minutes%=60;
        hour%=24;
        if(hour<=9)out.print(0+""+hour);
        else out.print(hour);
        out.print(":");
        if(minutes<=9)out.print(0+""+minutes);
        else out.print(minutes);

        out.close();
    }
}