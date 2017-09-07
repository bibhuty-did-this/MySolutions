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
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_433B_KuriyamaMiraisStone{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _433B_ solver=new _433B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _433B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            long[] v=new long[n];
            long[] u=new long[n];
            ArrayList<Long> numbers=new ArrayList<>();
            for(int i=0;i<n;++i)
                numbers.add(in.nextLong());
            v[0]=numbers.get(0);
            for(int i=1;i<n;++i)
                v[i]=v[i-1]+numbers.get(i);
            Collections.sort(numbers);
            u[0]=numbers.get(0);
            for(int i=1;i<n;++i)
                u[i]=u[i-1]+numbers.get(i);
            int queries=in.nextInt();
            while(queries-->0){
                int type=in.nextInt();
                if(type==1){
                    int l=in.nextInt()-1;
                    int r=in.nextInt()-1;
                    if(l==0) out.println(v[r]);
                    else out.println(v[r]-v[l-1]);
                }else{
                    int l=in.nextInt()-1;
                    int r=in.nextInt()-1;
                    if(l==0) out.println(u[r]);
                    else out.println(u[r]-u[l-1]);
                }
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
                if(c<'0' || c>'9'){
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

        public void println(long i){
            writer.println(i);
        }

    }
}

