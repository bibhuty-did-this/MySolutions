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
public class Code_508A_PashaAndPixels{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _508A_ solver=new _508A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _508A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            /**
             * Date: 16th May 2017
             * Question number: 13
             * Start time: 10:30 AM
             * Submission-1: 10:52 AM(22 minutes)
             */
            int n=in.nextInt(), m=in.nextInt(), k=in.nextInt();
            boolean[][] board=new boolean[n][m];
            for(int i=1;i<=k;++i){
                int row=in.nextInt()-1;
                int col=in.nextInt()-1;
                board[row][col]=true;
                if(row+1<n && col+1<m && board[row+1][col] && board[row][col+1] && board[row+1][col+1]){
                    out.print(i);
                    return;
                }
                if(row-1>=0 && col+1<m && board[row][col+1] && board[row-1][col] && board[row-1][col+1]){
                    out.print(i);
                    return;
                }
                if(row-1>=0 && col-1>=0 && board[row-1][col] && board[row-1][col-1] && board[row][col-1]){
                    out.print(i);
                    return;
                }
                if(row+1<n && col-1>=0 && board[row][col-1] && board[row+1][col] && board[row+1][col-1]){
                    out.print(i);
                    return;
                }
            }
            out.print(0);
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

        public void print(int i){
            writer.print(i);
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
                if(c<'0' || c>'9'){
                    throw new InputMismatchException();
                }
                res*=10;
                res+=c-'0';
                c=read();
            }while(!isSpaceChar(c));
            return res*sgn;
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

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

