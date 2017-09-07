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
public class Code_816A_CarenAndMorning{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _816A_ solver=new _816A_();
        solver.solve(1,in,out);
        out.close();
    }
    static class _816A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            String s=in.next();
            int hour=(s.charAt(0)-'0')*10+(s.charAt(1)-'0');
            int minutes=(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
            int reverseHour=(hour%10)*10+hour/10;
            if(reverseHour>=minutes && reverseHour<60) out.print(reverseHour-minutes);
            else{
                hour=(hour+1)%24;
                if(hour>=6 && hour<=9) out.print(60-minutes+60*(10-hour)+1);
                else if(hour>=16 && hour<=19) out.print(60-minutes+60*(20-hour)+2);
                else out.print(60-minutes+((hour%10)*10+hour/10));
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

