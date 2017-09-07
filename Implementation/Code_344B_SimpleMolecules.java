import java.util.Scanner;
import java.io.PrintWriter;

public class Code_344B_SimpleMolecules{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int a=in.nextInt(),b=in.nextInt(),c=in.nextInt();
        int x=(a-c+b),y=(c+b-a),z=(c-b+a);
        if(x%2==0 && y%2==0 && z%2==0 && x>=0 && y>=0 && z>=0){
            if((x==0 && y==0) || (y==0 && z==0) || (x==0 && z==0))out.print("Impossible");
            else out.print(x/2+" "+y/2+" "+z/2);
        }else out.print("Impossible");

        out.flush();
        out.close();
    }
}