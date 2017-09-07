import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_611C_NewYearAndDomino{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _611C_ solver=new _611C_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _611C_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int row=in.nextInt(), col=in.nextInt();
            char[][] grid=new char[row][col];
            for(int i=0;i<row;++i)
                grid[i]=in.next().toCharArray();
            int[][] gridRow=new int[row][col];
            for(int i=0;i<row;++i){
                for(int j=1;j<col;++j){
                    if(grid[i][j]=='.'&&grid[i][j-1]=='.') gridRow[i][j]=1+gridRow[i][j-1];
                    else gridRow[i][j]=gridRow[i][j-1];
                }
            }
            int[][] gridCol=new int[row][col];
            for(int j=0;j<col;++j){
                for(int i=1;i<row;++i){
                    if(grid[i][j]=='.'&&grid[i-1][j]=='.') gridCol[i][j]=gridCol[i-1][j]+1;
                    else gridCol[i][j]=gridCol[i-1][j];
                }
            }
            int n=in.nextInt();
            while(n-->0){
                int r1=in.nextInt()-1, c1=in.nextInt()-1, r2=in.nextInt()-1, c2=in.nextInt()-1;
                int total=0;
                for(int i=r1;i<=r2;++i) total+=gridRow[i][c2]-gridRow[i][c1];
                for(int i=c1;i<=c2;++i) total+=gridCol[r2][i]-gridCol[r1][i];
                out.println(total);
            }
        }

    }

    static class InputReader{
        private InputStream stream;
        private byte[] buf=new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream){
            this.stream=stream;
        }

        public int read(){
            if(numChars==-1){
                throw new InputMismatchException();
            }
            if(curChar>=numChars){
                curChar=0;
                try{
                    numChars=stream.read(buf);
                }catch(IOException e){
                    throw new InputMismatchException();
                }
                if(numChars<=0){
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt(){
            int c=read();
            while(isSpaceChar(c)){
                c=read();
            }
            int sgn=1;
            if(c=='-'){
                sgn=-1;
                c=read();
            }
            int res=0;
            do{
                if(c<'0'||c>'9'){
                    throw new InputMismatchException();
                }
                res*=10;
                res+=c-'0';
                c=read();
            }while(!isSpaceChar(c));
            return res*sgn;
        }

        public String nextString(){
            int c=read();
            while(isSpaceChar(c)){
                c=read();
            }
            StringBuilder res=new StringBuilder();
            do{
                if(Character.isValidCodePoint(c)){
                    res.appendCodePoint(c);
                }
                c=read();
            }while(!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c){
            if(filter!=null){
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c){
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }

        public String next(){
            return nextString();
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter{
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream){
            writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer){
            this.writer=new PrintWriter(writer);
        }

        public void close(){
            writer.close();
        }

        public void println(int i){
            writer.println(i);
        }

    }
}

