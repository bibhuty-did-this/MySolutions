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
public class Code_712B_MemoryAndTrident{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _712B_ solver=new _712B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _712B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            /**
             * Date: 16th May 2017
             * Question number: 2
             * Start time: 2:23 AM
             * End time: 2:42 AM
             */
            String s=in.next();
            int l=0, r=0, u=0, d=0;
            for(int i=0;i<s.length();++i){
                if(s.charAt(i)=='L') ++l;
                else if(s.charAt(i)=='R') ++r;
                else if(s.charAt(i)=='U') ++u;
                else ++d;
            }
        /*
        -- Wrong logic
        if(Math.abs(r-l)==Math.abs(u-d))out.print(Math.abs(u-d));
        else out.print(-1);
        */
            if(Math.abs(r-l)%2==0 && Math.abs(u-d)%2==0) out.print(Math.abs(r-l)/2+Math.abs(u-d)/2);
            else if(Math.abs(r-l)%2==1 && Math.abs(u-d)%2==1) out.print(Math.abs(r-l)/2+Math.abs(u-d)/2+1);
            else out.print(-1);

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
            return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
        }

        public String next(){
            return nextString();
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

