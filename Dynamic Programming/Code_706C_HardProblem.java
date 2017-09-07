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
public class Code_706C_HardProblem{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _706C_ solver=new _706C_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _706C_{
        static long INF=(long)1e14+1;

        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            long c[]=in.nextLongArray(n);
            String[] strings=new String[n];
            String[] rstrings=new String[n];
            long[][] dp=new long[n][2];
            for(int i=0;i<n;++i){
                StringBuilder get=new StringBuilder(in.next());
                strings[i]=get.toString();
                rstrings[i]=get.reverse().toString();
            }
            dp[0][0]=0;
            dp[0][1]=c[0];
            for(int i=1;i<n;++i){

                dp[i][0]=INF;
                dp[i][1]=INF;

                if(strings[i].compareTo(strings[i-1])>=0) dp[i][0]=Math.min(dp[i-1][0],dp[i][0]);
                if(strings[i].compareTo(rstrings[i-1])>=0) dp[i][0]=Math.min(dp[i-1][1],dp[i][0]);

                if(rstrings[i].compareTo(strings[i-1])>=0) dp[i][1]=Math.min(c[i]+dp[i-1][0],dp[i][1]);
                if(rstrings[i].compareTo(rstrings[i-1])>=0) dp[i][1]=Math.min(c[i]+dp[i-1][1],dp[i][1]);

            }
            long ans=Math.min(dp[n-1][0],dp[n-1][1]);
            out.print(ans>=INF?-1:ans);
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

        public void print(long i){
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

        public long nextLong(){
            int c=read();
            while(isSpaceChar(c)){
                c=read();
            }
            int sgn=1;
            if(c=='-'){
                sgn=-1;
                c=read();
            }
            long res=0;
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

        public long[] nextLongArray(int n){
            long[] array=new long[n];
            for(int i=0;i<n;++i) array[i]=nextLong();
            return array;
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

