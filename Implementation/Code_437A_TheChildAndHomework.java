import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_437A_TheChildAndHomework{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _437A_ solver=new _437A_();
        solver.solve(1,in,out);
        out.close();
    }
    static class _437A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            ArrayList<Option> options=new ArrayList<>();
            for(int i=0;i<4;++i){
                String text=in.next();
                int length=text.length()-2;
                options.add(new Option(text,length));
            }
            Collections.sort(options,Comparator.comparingInt(o->o.length));
            if(2*options.get(0).length<=options.get(1).length && 2*options.get(2).length<=options.get(3).length)
                out.print('C');
            else if(2*options.get(0).length<=options.get(1).length)
                out.print(options.get(0).text.charAt(0));
            else if(2*options.get(2).length<=options.get(3).length)
                out.print(options.get(3).text.charAt(0));
            else out.print('C');
        }
    }
    static class Option{
        public String text;
        public int length;
        public Option(String text,int length){
            this.text=text;
            this.length=length;
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
        public void print(char i){
            writer.print(i);
        }
        public void close(){
            writer.close();
        }
    }
}

