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
public class Code_387A_GeorgeAndSleep{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _387A_ solver=new _387A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _387A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            String current=in.next(), duration=in.next();
            int cHour=(current.charAt(0)-'0')*10+(current.charAt(1)-'0');
            int cMinute=(current.charAt(3)-'0')*10+(current.charAt(4)-'0');
            int dHour=(duration.charAt(0)-'0')*10+(duration.charAt(1)-'0');
            int dMinutes=(duration.charAt(3)-'0')*10+(duration.charAt(4)-'0');
            if(cMinute<dMinutes){
                cMinute+=60;
                --cHour;
            }
            if(cHour<dHour){
                cHour+=24;
            }
            out.printf("%02d:%02d",(cHour-dHour),(cMinute-dMinutes));
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

        public void printf(String format,Object... objects){
            writer.printf(format,objects);
        }

        public void close(){
            writer.close();
        }

    }
}

