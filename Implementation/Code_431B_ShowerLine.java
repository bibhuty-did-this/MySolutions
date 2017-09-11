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
public class Code_431B_ShowerLine{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _431B_ solver=new _431B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _431B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int[][] matrix=in.nextIntMatrix(5,5);
            int max=0;
            for(int a=0;a<5;++a)
                for(int b=0;b<5;++b)
                    if(b!=a)
                        for(int c=0;c<5;++c)
                            if(c!=b&&c!=a)
                                for(int d=0;d<5;++d)
                                    if(d!=c&&d!=b&&d!=a)
                                        for(int e=0;e<5;++e)
                                            if(e!=d&&e!=c&&e!=b&&e!=a)
                                                max=Math.max(matrix[a][b]+matrix[b][a]+matrix[b][c]+matrix[c][b]+2*(matrix[c][d]+matrix[d][c])+2*(matrix[d][e]+matrix[e][d]),max);
            out.print(max);

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

        public int[][] nextIntMatrix(int n,int m){
            int[][] matrix=new int[n][m];
            for(int i=0;i<n;++i)
                for(int j=0;j<m;++j)
                    matrix[i][j]=nextInt();
            return matrix;
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

