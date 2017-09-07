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
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_414B_MashmokhAndACM{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _414B_ solver=new _414B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _414B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), k=in.nextInt(), MOD=(int)1e9+7;
            ArrayList<Integer>[] divisors=new ArrayList[n+1];
            for(int i=0;i<=n;++i) divisors[i]=new ArrayList<>();
            for(int i=1;i<=n;++i){
                int limit=(int)Math.sqrt(i);
                for(int j=1;j<=limit;++j){
                    if(i%j==0){
                        if(j==i/j) divisors[i].add(j);
                        else{
                            divisors[i].add(j);
                            divisors[i].add(i/j);
                        }
                    }
                }
            }
            int[][] dp=new int[k+1][n+1];
            Arrays.fill(dp[1],1);
            for(int i=2;i<=k;++i){
                for(int j=1;j<=n;++j){
                    for(int d : divisors[j]){
                        dp[i][j]+=dp[i-1][d];
                        dp[i][j]%=MOD;
                    }
                }
            }
        /*for(int i=1;i<=n;++i){
            for(int d:divisors[i])out.print(d,"");
            out.println();
        }
        out.println();
        for(int i=1;i<=k;++i){
            for(int j=1;j<=n;++j){
                out.print(dp[i][j],"");
            }
            out.println();
        }*/
            int sum=0;
            for(int i=1;i<=n;++i) sum=(sum+dp[k][i])%MOD;
            out.print(sum);
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

