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
import java.util.Collections;
import java.io.InputStream;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_157B_Trace{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _157B_ solver=new _157B_();
        solver.solve(1,in,out);
        out.close();
    }
    static class _157B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            ArrayList<Integer> radius=new ArrayList<>(n);
            for(int i=0;i<n;++i) radius.add(in.nextInt());
            Collections.sort(radius);
            double red=0;
            if(n%2==1){
                red+=Math.PI*radius.get(0)*radius.get(0);
                for(int i=1;i<n;i+=2)
                    red+=(Math.PI*(radius.get(i+1)*radius.get(i+1)-radius.get(i)*radius.get(i)));
            }else
                for(int i=0;i<n;i+=2)
                    red+=(Math.PI*(radius.get(i+1)*radius.get(i+1)-radius.get(i)*radius.get(i)));
            out.print(red);
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
                if(c<'0' || c>'9'){
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
            return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
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
    }
}

