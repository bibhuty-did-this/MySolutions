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
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_493B_VasyaAndWrestling{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _493B_ solver=new _493B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _493B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            ArrayList<Integer> first=new ArrayList<>();
            ArrayList<Integer> second=new ArrayList<>();
            int point=0;
            long firstSum=0, secondSum=0;
            while(n-->0){
                point=in.nextInt();
                if(point>0){
                    first.add(point);
                    firstSum+=point;
                }else{
                    second.add(-1*point);
                    secondSum-=point;
                }
            }
            if(firstSum>secondSum) out.print("first");
            else if(firstSum<secondSum) out.print("second");
            else{
                int fSize=first.size(), sSize=second.size(), min=Math.min(fSize,sSize);
                for(int i=0;i<min;++i){
                    if(first.get(i)>second.get(i)){
                        out.print("first");
                        return;
                    }else if(first.get(i)<second.get(i)){
                        out.print("second");
                        return;
                    }else continue;
                }
                if(first.size()>second.size()) out.print("first");
                else if(first.size()<second.size()) out.print("second");
                else{
                    if(point>0) out.print("first");
                    else out.print("second");
                }
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

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

