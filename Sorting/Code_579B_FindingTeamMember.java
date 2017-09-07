import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;

public class Code_579B_FindingTeamMember{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        ArrayList<Strength> list=new ArrayList<>();
        for(int i=2;i<=2*n;++i)
            for(int j=1;j<i;++j)
                list.add(new Strength(i,j,in.nextInt()));
        Collections.sort(list,Comparator.comparingInt(o->-o.strength));
        int[] taken=new int[2*n+1];
        for(Strength strength:list){
            if(taken[strength.i]==0 && taken[strength.j]==0){
                taken[strength.i]=strength.j;
                taken[strength.j]=strength.i;
            }
        }
        for(int i=1;i<=2*n;++i)
            out.print(taken[i]+" ");
        out.close();
    }
}
class Strength{
    int i,j,strength;
    public Strength(int i,int j,int strength){
        this.i=i;
        this.j=j;
        this.strength=strength;
    }
}