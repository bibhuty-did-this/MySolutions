import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
public class Code_777B_GameOfCreditCards{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _777B_ solver=new _777B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _777B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            int[] moriarity=new int[10];
            Arrays.fill(moriarity,0);
            String s=in.next(), m=in.next();
            for(int i=0;i<n;++moriarity[m.charAt(i++)-'0']) ;
            out.println(min(s,moriarity));
            out.println(max(s,moriarity));

        }

        public int min(String s,int[] m){
            int[] moriarity=Arrays.copyOf(m,10);
            int size=s.length(), total=0;
            for(int i=0;i<size;++i){
                int num=s.charAt(i)-'0';
                boolean getFlick=true;
                for(int j=num;j<10;++j){
                    if(moriarity[j]>0){
                        --moriarity[j];
                        getFlick=false;
                        break;
                    }
                }
                if(getFlick){
                    ++total;
                    for(int j=0;j<num;++j){
                        if(moriarity[j]>0){
                            --moriarity[j];
                            break;
                        }
                    }
                }
            }
            return total;
        }

        public int max(String s,int[] m){
            int[] moriarity=Arrays.copyOf(m,10);
            int size=s.length(), total=0;

            for(int i=0;i<size;++i){
                int num=s.charAt(i)-'0';
                boolean getFlick=false;
                for(int j=num+1;j<10;++j){
                    if(moriarity[j]>0){
                        --moriarity[j];
                        getFlick=true;
                        ++total;
                        break;
                    }
                }
                if(!getFlick){
                    for(int j=0;j<=num;++j){
                        if(moriarity[j]>0){
                            --moriarity[j];
                            break;
                        }
                    }
                }
            }

            return total;
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

        public void println(int i){
            writer.println(i);
        }

    }
}

