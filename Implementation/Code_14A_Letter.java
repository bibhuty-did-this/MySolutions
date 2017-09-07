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
public class Code_14A_Letter{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _14A_ solver=new _14A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _14A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), m=in.nextInt();
            char[][] masterpiece=new char[n][m];
            for(int i=0;i<n;++i)
                for(int j=0;j<m;++j)
                    masterpiece[i][j]=in.nextCharacter();
            int rstart=0, rend=n-1, cstart=0, cend=m-1;
            outer1:
            while(true){
                for(int i=0;i<m;++i)
                    if(masterpiece[rstart][i]=='*')
                        break outer1;
                ++rstart;
            }
            outer2:
            while(true){
                for(int i=0;i<m;++i)
                    if(masterpiece[rend][i]=='*')
                        break outer2;
                --rend;
            }
            outer3:
            while(true){
                for(int i=0;i<n;++i)
                    if(masterpiece[i][cstart]=='*')
                        break outer3;
                ++cstart;
            }

            outer4:
            while(true){
                for(int i=0;i<n;++i)
                    if(masterpiece[i][cend]=='*')
                        break outer4;
                --cend;
            }
            for(int row=rstart;row<=rend;++row){
                for(int col=cstart;col<=cend;++col){
                    out.print(masterpiece[row][col]);
                }
                out.println();
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

        public boolean isSpaceChar(int c){
            if(filter!=null){
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c){
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }

        public char nextCharacter(){
            int c=read();
            while(isSpaceChar(c)){
                c=read();
            }
            return (char)c;
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

        public void println(){
            writer.println();
        }

        public void print(char i){
            writer.print(i);
        }

        public void close(){
            writer.close();
        }

    }
}

