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
public class Code_78A_Haiku{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _78A_ solver=new _78A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _78A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            if(syllables(in.readLine())!=5){
                out.print("NO");
                return;
            }
            if(syllables(in.readLine())!=7){
                out.print("NO");
                return;
            }
            if(syllables(in.readLine())!=5){
                out.print("NO");
                return;
            }
            out.print("YES");
        }

        public int syllables(String s){
            int total=0, size=s.length();
            for(int i=0;i<size;++i)
                if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
                    ++total;
            return total;
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

    }

    static class InputReader{
        private InputStream stream;
        private byte[] buf=new byte[1024];
        private int curChar;
        private int numChars;

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

        private String readLine0(){
            StringBuilder buf=new StringBuilder();
            int c=read();
            while(c!='\n'&&c!=-1){
                if(c!='\r'){
                    buf.appendCodePoint(c);
                }
                c=read();
            }
            return buf.toString();
        }

        public String readLine(){
            String s=readLine0();
            while(s.trim().length()==0){
                s=readLine0();
            }
            return s;
        }

    }
}

