import java.util.Scanner;
import java.io.PrintWriter;

public class Code_828B_BlackSquare{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int row=in.nextInt(),col=in.nextInt();
        char[][] sheet=new char[row][col];
        for(int r=0;r<row;++r)
            sheet[r]=in.next().toCharArray();
        int blackCells=0,minI=row,minJ=col,maxI=-1,maxJ=-1;
        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                if(sheet[i][j]=='B'){
                    ++blackCells;
                    minI=Math.min(minI,i);
                    minJ=Math.min(minJ,j);
                    maxI=Math.max(maxI,i);
                    maxJ=Math.max(maxJ,j);
                }
            }
        }
        if(blackCells==0)out.print(1);
        else if(blackCells==1)out.print(0);
        else{
            int length=maxI-minI+1;
            int width=maxJ-minJ+1;
            if(Math.max(length,width)<=Math.min(row,col))
                out.print((int)Math.pow(Math.max(length,width),2)-blackCells);
            else out.print(-1);
        }
        out.close();


        /*for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                for(int l=1;l<=maxLength;++l){
                    if(i+l-1<row && j+l-1<col){
                        int countBlack=0;
                        for(int a=0;a<l;++a)
                            for(int b=0;b<l;++b)
                                if(sheet[i+a][j+b]=='Code_854B_MaximBuysAnApartment')
                                    ++countBlack;
                        if(countBlack==blackCells){
                            //out.println(i+" "+j+" "+l);
                            minPainting=Math.min(l*l-blackCells,minPainting);
                        }
                    }else break;
                }
            }
        }*/
    }
}
