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
public class Code_708A_LettersCyclicShift{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _708A_ solver=new _708A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _708A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            /**
             * Date: 16th May 2017
             * Question number: 14
             * Start time: 10:56 AM
             * Submission-1: 11:07 AM(11 minutes)--left the base case when the length of string is 1
             * Submission-2: 11:11 AM(15 minutes)--left the base case when all the characters are 'a'
             * Submission-3: 11:14 AM(18 minutes)--submitted finally
             */
            String s=in.next();
            if(isAll_a(s)){
                out.print(s.substring(0,s.length()-1)+"z");
                return;
            }
            if(s.length()==1){
                out.print((char)(s.charAt(0)-1));
                return;
            }

            int i=0;
            if(s.charAt(i)=='a'){
                while(i<s.length() && s.charAt(i)=='a'){
                    out.print(s.charAt(i));
                    ++i;
                }
            }
            int j=i;
            while(j<s.length() && s.charAt(j)!='a'){
                out.print((char)(s.charAt(j)-1));
                ++j;
            }
            while(j<s.length()) out.print(s.charAt(j++));
        }

        boolean isAll_a(String s){
            for(int i=0;i<s.length();++i)
                if(s.charAt(i)!='a')
                    return false;
            return true;
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

        public void print(char i){
            writer.print(i);
        }

        public void close(){
            writer.close();
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

