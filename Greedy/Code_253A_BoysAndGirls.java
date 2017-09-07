import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Code_253A_BoysAndGirls{
    public static void main(String[] args) throws Exception{
        Scanner in=new Scanner(new File("input.txt"));
        PrintStream out=new PrintStream("output.txt");
        int boys=in.nextInt(),girls=in.nextInt();
        if(boys>=girls){
            while(girls>0){
                out.print('B');
                --boys;
                out.print('G');
                --girls;
            }
            while(boys>0){
                out.print('B');
                --boys;
            }
        }else{
            while(boys>0){
                out.print('G');
                --girls;
                out.print('B');
                --boys;
            }
            while(girls>0){
                out.print('G');
                --girls;
            }
        }
        out.close();

    }
}
