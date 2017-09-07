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
public class Code_545C_Woodcutters{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        Task545C solver=new Task545C();
        solver.solve(1,in,out);
        out.close();
    }

    static class Task545C{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            int[] x=new int[n];
            int[] h=new int[n];
            for(int i=0;i<n;++i){
                x[i]=in.nextInt();
                h[i]=in.nextInt();
            }
            int[] left=new int[n];
            int[] right=new int[n];
            left[0]=1;
            for(int i=1;i<n;++i){
                left[i]=Math.max(left[i-1],right[i-1]);//The case when the tree could not be cut

                //The case where both the tree and the tree left adjacent to it could be cut
                if(x[i]-h[i]>x[i-1]+h[i-1])
                    left[i]=Math.max(left[i-1],right[i-1])+1;

                //The case when only it could be cut down to left
                if(x[i]-h[i]>x[i-1])
                    left[i]=Math.max(left[i],left[i-1]+1);

                //The case when the tree could be cut down to the right
                if(i==n-1 || (x[i]+h[i]<x[i+1]))
                    right[i]=Math.max(left[i-1],right[i-1])+1;
            }

            //Print the best case
            out.print(Math.max(left[n-1],right[n-1]));
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
}

