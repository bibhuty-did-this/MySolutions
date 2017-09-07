import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
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
public class Code_558B_AmrAndTheLargeArray{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _558B_ solver=new _558B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _558B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            int array[]=in.nextIntArray(n);
            int[] start=new int[1000001];
            int[] end=new int[1000001];
            int maxSize=1;
            Map<Integer,Integer> pair=new HashMap<>();
            for(int i=0;i<n;++i){
                if(pair.containsKey(array[i])){
                    pair.replace(array[i],pair.get(array[i])+1);
                    end[array[i]]=i+1;
                    maxSize=Math.max(maxSize,pair.get(array[i]));
                }else{
                    pair.put(array[i],1);
                    start[array[i]]=i+1;
                    end[array[i]]=i+1;
                }
            }
            int first=0, last=0, gap=Integer.MAX_VALUE;
            for(int key : pair.keySet()){
                if(pair.get(key)==maxSize){
                    if(end[key]-start[key]<gap){
                        gap=end[key]-start[key];
                        first=start[key];
                        last=end[key];
                    }
                }
            }
            out.print(first,last);
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

        public int[] nextIntArray(int n){
            int[] array=new int[n];
            for(int i=0;i<n;++i) array[i]=nextInt();
            return array;
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

