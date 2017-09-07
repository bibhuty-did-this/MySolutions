import java.util.Scanner;
import java.io.PrintWriter;

public class Code_416B_ArtUnion{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int pictures=in.nextInt(),painters=in.nextInt();
        int[][] time=new int[pictures][painters];
        for(int i=0;i<pictures;++i)
            for(int j=0;j<painters;++j)
                time[i][j]=in.nextInt();

        int[][] schedule=new int[painters][pictures];
        int extra=0;
        for(int i=0;i<pictures;extra+=time[i][0],++i)
            schedule[0][i]=extra+time[i][0];
        for(int i=1;i<painters;++i){
            for(int j=0;j<pictures;++j){
                schedule[i][j]=Math.max(schedule[i-1][j],(j-1>=0?schedule[i][j-1]:0))+time[j][i];
            }
        }
        for(int i=0;i<pictures;++i)
            out.print(schedule[painters-1][i]+" ");

        out.flush();
        out.close();
    }
}