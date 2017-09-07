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
public class Code_424A_Squats{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _424A_ solver=new _424A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _424A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            char[] hamsters=new char[n];
            int standing=0, sitting=0;
            for(int i=0;i<n;++i){
                hamsters[i]=in.nextCharacter();
                if(Character.isUpperCase(hamsters[i])) ++standing;
                else ++sitting;
            }
            if(standing>sitting){
                standing-=n/2;
                out.println(standing);
                for(int i=0;i<n&&standing>0;++i){
                    if(Character.isUpperCase(hamsters[i])){
                        hamsters[i]=Character.toLowerCase(hamsters[i]);
                        --standing;
                    }
                }
            }else if(sitting>standing){
                sitting-=n/2;
                out.println(sitting);
                for(int i=0;i<n&&sitting>0;++i){
                    if(Character.isLowerCase(hamsters[i])){
                        hamsters[i]=Character.toUpperCase(hamsters[i]);
                        --sitting;
                    }
                }
            }else out.println(0);
            for(char c : hamsters) out.print(c);
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

        public void println(int i){
            writer.println(i);
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

        public boolean isSpaceChar(int c){
            if(filter!=null){
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c){
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }

        public char nextCharacter(){
            int c=read();
            while(isSpaceChar(c)){
                c=read();
            }
            return (char)c;
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

