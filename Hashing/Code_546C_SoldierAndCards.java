import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_546C_SoldierAndCards{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _546C_ solver=new _546C_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _546C_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n, k1, k2, steps=0;
            StringBuffer soldier1=new StringBuffer();
            StringBuffer soldier2=new StringBuffer();
            Set<String> state1=new HashSet<>();
            Set<String> state2=new HashSet<>();
            n=in.nextInt();
            k1=in.nextInt();
            while(k1-->0) soldier1.append(in.nextInt()-1);
            state1.add(new String(soldier1.toString().trim()));
            k2=in.nextInt();
            while(k2-->0) soldier2.append(in.nextInt()-1);
            state2.add(new String(soldier2.toString().trim()));
            //out.println(new String(soldier1.toString().trim())+" "+new String(soldier2.toString().trim()));
            while(soldier1.length()!=0 && soldier2.length()!=0){
                if(soldier1.charAt(0)>soldier2.charAt(0)){
                    soldier1.append(soldier2.charAt(0));
                    soldier1.append(soldier1.charAt(0));
                    soldier1.deleteCharAt(0);
                    soldier2.deleteCharAt(0);
                    if(state1.contains(new String(soldier1.toString().trim())) && state2.contains(new String(soldier2.toString().trim()))){
                        out.print(-1);
                        return;
                    }
                    state1.add(new String(soldier1.toString().trim()));
                    state2.add(new String(soldier2.toString().trim()));
                    ++steps;

                }else{
                    soldier2.append(soldier1.charAt(0));
                    soldier2.append(soldier2.charAt(0));
                    soldier2.deleteCharAt(0);
                    soldier1.deleteCharAt(0);
                    if(state1.contains(new String(soldier1.toString().trim())) && state2.contains(new String(soldier2.toString().trim()))){
                        out.print(-1);
                        return;
                    }
                    state1.add(new String(soldier1.toString().trim()));
                    state2.add(new String(soldier2.toString().trim()));
                    ++steps;
                }
            }
            out.print(steps+" ");
            if(soldier1.length()==0) out.print(2);
            else out.print(1);
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

        public void print(int i){
            writer.print(i);
        }

    }
}

