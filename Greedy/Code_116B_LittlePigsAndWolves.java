import java.util.Scanner;
import java.io.PrintWriter;

public class Code_116B_LittlePigsAndWolves{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int row=in.nextInt(),col=in.nextInt();
        char[][] grid=new char[row][col];
        for(int i=0;i<row;++i)
            grid[i]=in.next().toCharArray();
        boolean[][] wolfTaken=new boolean[row][col];
        int pigsEaten=0;
        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                if(grid[i][j]=='P'){
                    if(j+1<col && grid[i][j+1]=='W' && !wolfTaken[i][j+1]){
                        wolfTaken[i][j+1]=true;
                        ++pigsEaten;
                    }else if(j-1>=0 && grid[i][j-1]=='W' && !wolfTaken[i][j-1]){
                        wolfTaken[i][j-1]=true;
                        ++pigsEaten;
                    }else if(i-1>=0 && grid[i-1][j]=='W' && !wolfTaken[i-1][j]){
                        wolfTaken[i-1][j]=true;
                        ++pigsEaten;
                    }else if(i+1<row && grid[i+1][j]=='W' && !wolfTaken[i+1][j]){
                        wolfTaken[i+1][j]=true;
                        ++pigsEaten;
                    }
                }
            }
        }
        out.print(pigsEaten);
        out.close();
    }
}