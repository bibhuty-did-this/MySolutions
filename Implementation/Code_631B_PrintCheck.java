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
public class Code_631B_PrintCheck{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _631B_ solver=new _631B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _631B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), m=in.nextInt(), k=in.nextInt();
            int[] row_occurence=new int[n];
            int[] col_occurence=new int[m];
            int[] row_color=new int[n];
            int[] col_color=new int[m];
            int step=0;
            while(k-->0){
                int status=in.nextInt();
                if(status==1){
                    int row=in.nextInt()-1;
                    row_color[row]=in.nextInt();
                    row_occurence[row]=++step;
                }else{
                    int col=in.nextInt()-1;
                    col_color[col]=in.nextInt();
                    col_occurence[col]=++step;
                }
            }
            for(int i=0;i<n;++i){
                for(int j=0;j<m;++j){
                    if(row_occurence[i]>col_occurence[j]) out.print(row_color[i]);
                    else out.print(col_color[j]);
                    out.print(' ');
                }
                out.println();
            }
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

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

