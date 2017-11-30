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
public class Code_894A_QAQ{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _894A_ solver=new _894A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _894A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            String s=in.next();
            int size=s.length(), total=0, counter=0;
        /*
        for(int i=0;i<size;++i)
            for(int j=i+1;j<size;++j)
                for(int k=j+1;k<size;++k)
                    if(s.charAt(i)=='Q' && s.charAt(j)=='A' && s.charAt(k)=='Q')
                        ++total;
        */
            int[] b=new int[size];
            for(int i=0;i<size;++i){
                if(s.charAt(i)=='Q') ++counter;
                b[i]=counter;
            }
            for(int i=1;i<size-1;++i)
                if(s.charAt(i)=='A')
                    total+=b[i-1]*(b[size-1]-b[i-1]);

            out.print(total);
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
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }

        public String next(){
            return nextString();
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

