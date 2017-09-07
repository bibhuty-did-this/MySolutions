import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_650A_Watchmen{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _650A_ solver=new _650A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _650A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            Map<String,Integer> equivalent=new HashMap<>();
            Map<Integer,Integer> xOccurence=new HashMap();
            Map<Integer,Integer> yOccurence=new HashMap<>();
            Set<String> points=new HashSet<>();
            for(int i=0;i<n;++i){
                int get_x=in.nextInt();
                int get_y=in.nextInt();
                if(xOccurence.containsKey(get_x)){
                    xOccurence.replace(get_x,xOccurence.get(get_x)+1);
                }else xOccurence.put(get_x,1);
                if(yOccurence.containsKey(get_y)){
                    yOccurence.replace(get_y,yOccurence.get(get_y)+1);
                }else yOccurence.put(get_y,1);
                String s=Integer.toString(get_x).concat("_").concat(Integer.toString(get_y));
                int size=points.size();
                points.add(s);
                if(size==points.size()){
                    if(equivalent.containsKey(s)){
                        equivalent.replace(s,equivalent.get(s)+1);
                    }else equivalent.put(s,2);
                }
            }
            long total=0;
            for(int x : xOccurence.keySet()){
                long frequency=(long)xOccurence.get(x);
                total+=((frequency)*(frequency-1))/2;
            }
            for(int y : yOccurence.keySet()){
                long frequency=(long)yOccurence.get(y);
                total+=((frequency)*(frequency-1))/2;
            }
            for(String s : equivalent.keySet()){
                long frequency=(long)equivalent.get(s);
                total-=((frequency)*(frequency-1))/2;
            }
            out.print(total);
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

        public void close(){
            writer.close();
        }

        public void print(long i){
            writer.print(i);
        }

    }
}

