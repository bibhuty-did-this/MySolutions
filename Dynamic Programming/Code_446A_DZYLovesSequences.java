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
public class Code_446A_DZYLovesSequences{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _446A_ solver=new _446A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _446A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), a[]=in.nextIntArray(n);
            int[] leftMax=new int[n];
            int[] rightMax=new int[n];
            int max=1;

            //Finding the max sequence as traversed from left
            leftMax[0]=1;
            for(int i=1;i<n;++i)
                leftMax[i]=(a[i]>a[i-1]?leftMax[i-1]+1:1);

            //finding the max sequence as traversed from right
            rightMax[n-1]=1;
            for(int i=n-2;i>=0;--i)
                rightMax[i]=(a[i]<a[i+1]?rightMax[i+1]+1:1);

            //for corner cases i.e. when the pointer is at the extreme ends
            max=Math.max(rightMax[0],leftMax[n-1]);

            //Calculate max when only traversed from left to right
            for(int i=1;i<n;++i)
                max=Math.max(max,leftMax[i-1]+1);

            //Calculate the max when only traversed from right to left
            for(int i=0;i<n-1;++i)
                max=Math.max(max,1+rightMax[i+1]);

            //Calculate for both the sides
            for(int i=1;i<n-1;++i)
                if(a[i-1]+1<=a[i+1]-1)
                    max=Math.max(max,leftMax[i-1]+1+rightMax[i+1]);

            //Display the result
            out.print(max);

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

        public int[] nextIntArray(int n){
            int[] array=new int[n];
            for(int i=0;i<n;++i) array[i]=nextInt();
            return array;
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

