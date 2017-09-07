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
public class Code_482A_DiversePermutation{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _482A_ solver=new _482A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _482A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            /**
             * Date: 16th May 2017
             * Question number: 9
             * Start time: 5:32 AM
             * Break at: 5:50 AM
             * Resume: 6:28 PM
             * End time: 6:55 AM
             * Time taken: 50 minutes
             */
            //It is necessary sometimes to identify the sequence of operations
            int n=in.nextInt(), k=in.nextInt();
            int current=1;
            boolean[] isVisited=new boolean[n+1];
            out.print(1+" ");
            isVisited[current]=true;
            for(int i=1;i<n && k!=0;++i){
                if(i%2==1){
                    current+=k;
                    out.print(current+" ");
                }else{
                    current-=k;
                    out.print(current+" ");
                }
                isVisited[current]=true;
                --k;
            }
            for(int i=1;i<=n;++i) if(!isVisited[i]) out.print(i+" ");
        /*
        -- Wrong approach as the printed value exceeds n
        int current=1;
        out.print(current+" ");
        for(int i=2;i<=n;++i){
            current+=k;
            out.print(current+" ");
            if(k>1)--k;
        }
        */

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

