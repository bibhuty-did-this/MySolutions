import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
public class Code_550B_PreparingOlympiads{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _550B_ solver=new _550B_();
        solver.solve(1,in,out);
        out.close();
    }
    static class _550B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), l=in.nextInt(), r=in.nextInt(), x=in.nextInt(), c[]=in.nextSortedIntArray(n), answer=0;
            for(int mask=0;mask<1<<n;++mask){
                if(Integer.bitCount(mask)<2) continue;
                int total=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
                for(int i=0;i<n;++i){
                    //if(((1<<i)&mask)!=0) can also be used for the same action
                    if((mask>>i)%2==1){
                        min=Math.min(min,c[i]);
                        max=Math.max(max,c[i]);
                        total+=c[i];
                    }
                }
                if(total>=l && total<=r && max-min>=x) ++answer;
            }
            out.print(answer);
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
        public int[] nextIntArray(int n){
            int[] array=new int[n];
            for(int i=0;i<n;++i) array[i]=nextInt();
            return array;
        }
        public int[] nextSortedIntArray(int n){
            int array[]=nextIntArray(n);
            Arrays.sort(array);
            return array;
        }
        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);
        }
    }
}

