import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.InputStream;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_614A_LinkCutTree{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _614A_ solver=new _614A_();
        solver.solve(1,in,out);
        out.close();
    }
    static class _614A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            BigInteger l=new BigInteger(in.next()), r=new BigInteger(in.next()), k=new BigInteger(in.next()), current=BigInteger.ONE;
            boolean flag=false;
            while(current.compareTo(r)<=0){
                if(current.compareTo(l)>=0){
                    flag=true;
                    out.print(current.toString(),"");
                }
                current=current.multiply(k);
            }
            if(!flag) out.print(-1);
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
        public void close(){
            writer.close();
        }
        public void print(int i){
            writer.print(i);
        }
    }
}

