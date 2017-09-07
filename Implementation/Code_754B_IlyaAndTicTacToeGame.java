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
public class Code_754B_IlyaAndTicTacToeGame{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _754B_ solver=new _754B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _754B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            char[][] grid=new char[4][4];
            grid[0]=in.next().toCharArray();
            grid[1]=in.next().toCharArray();
            grid[2]=in.next().toCharArray();
            grid[3]=in.next().toCharArray();
            for(int i=0;i<4;++i){
                for(int j=0;j<4;++j){
                    if(grid[i][j]=='.'){
                        if(j-2>=0){
                            if(grid[i][j-1]==grid[i][j-2] && grid[i][j-1]=='x'){
                                out.print("YES");
                                return;
                            }
                            if(i-2>=0 && grid[i-1][j-1]==grid[i-2][j-2] && grid[i-1][j-1]=='x'){
                                out.print("YES");
                                return;
                            }
                            if(i+2<4 && grid[i+1][j-1]==grid[i+2][j-2] && grid[i+1][j-1]=='x'){
                                out.print("YES");
                                return;
                            }
                        }
                        if(j+2<4){
                            if(grid[i][j+1]==grid[i][j+2] && grid[i][j+1]=='x'){
                                out.print("YES");
                                return;
                            }
                            if(i-2>=0 && grid[i-1][j+1]==grid[i-2][j+2] && grid[i-1][j+1]=='x'){
                                out.print("YES");
                                return;
                            }
                            if(i+2<4 && grid[i+1][j+1]==grid[i+2][j+2] && grid[i+1][j+1]=='x'){
                                out.print("YES");
                                return;
                            }
                        }
                        if(i-2>=0){
                            if(grid[i-1][j]==grid[i-2][j] && grid[i-1][j]=='x'){
                                out.print("YES");
                                return;
                            }
                        }
                        if(i+2<4){
                            if(grid[i+1][j]==grid[i+2][j] && grid[i+1][j]=='x'){
                                out.print("YES");
                                return;
                            }
                        }
                        if(i+1<4 && i-1>=0){
                            if(grid[i+1][j]==grid[i-1][j] && grid[i+1][j]=='x'){
                                out.print("YES");
                                return;
                            }
                        }
                        if(j+1<4 && j-1>=0){
                            if(grid[i][j+1]==grid[i][j-1] && grid[i][j-1]=='x'){
                                out.print("YES");
                                return;
                            }
                        }
                        if(j+1<4 && j-1>=0 && i+1<4 && i-1>=0){
                            if(grid[i-1][j+1]==grid[i+1][j-1] && grid[i-1][j+1]=='x'){
                                out.print("YES");
                                return;
                            }
                        }
                        if(j+1<4 && j-1>=0 && i+1<4 && i-1>=0){
                            if(grid[i+1][j+1]==grid[i-1][j-1] && grid[i-1][j-1]=='x'){
                                out.print("YES");
                                return;
                            }
                        }
                    }
                }
            }
            out.print("NO");

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
            return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
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

        public void print(Object... objects){
            for(int i=0;i<objects.length;i++){
                if(i!=0){
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void close(){
            writer.close();
        }

    }
}

