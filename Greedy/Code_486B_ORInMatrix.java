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
public class Code_486B_ORInMatrix{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _486B_ solver=new _486B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _486B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int row=in.nextInt(), col=in.nextInt();
            int[][] matrix=new int[row][col];
            int[][] original=new int[row][col];
            for(int i=0;i<row;++i)
                for(int j=0;j<col;++j)
                    original[i][j]=1;
            for(int i=0;i<row;++i){
                for(int j=0;j<col;++j){
                    matrix[i][j]=in.nextInt();
                    if(matrix[i][j]==0){
                        for(int k=0;k<row;++k) original[k][j]=0;
                        for(int l=0;l<col;++l) original[i][l]=0;
                    }
                }
            }
            for(int i=0;i<row;++i){
                for(int j=0;j<col;++j){
                    if(matrix[i][j]==1){
                        boolean oneFound=false;
                        if(!oneFound){
                            for(int k=0;k<row;++k){
                                if(original[k][j]==1){
                                    oneFound=true;
                                    break;
                                }
                            }
                        }
                        if(!oneFound){
                            for(int l=0;l<col;++l){
                                if(original[i][l]==1){
                                    oneFound=true;
                                    break;
                                }
                            }
                        }
                        if(!oneFound){
                            out.print("NO");
                            return;
                        }
                    }
                }
            }
            out.println("YES");
            for(int i=0;i<row;++i){
                for(int j=0;j<col;++j){
                    out.print(original[i][j],"");
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

        public void print(Object... objects){
            for(int i=0;i<objects.length;i++){
                if(i!=0){
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(){
            writer.println();
        }

        public void println(Object... objects){
            print(objects);
            writer.println();
        }

        public void close(){
            writer.close();
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

