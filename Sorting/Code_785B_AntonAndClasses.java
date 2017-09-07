import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_785B_AntonAndClasses{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        Task758B solver=new Task758B();
        solver.solve(1,in,out);
        out.close();
    }

    static class Task758B{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            Pair[] chess=new Pair[n];
            for(int i=0;i<n;++i) chess[i]=new Pair(in.nextInt(),in.nextInt());
            int m=in.nextInt();
            Pair[] programming=new Pair[m];
            for(int i=0;i<m;++i) programming[i]=new Pair(in.nextInt(),in.nextInt());
            int distance=0;
            Arrays.sort(chess,new Comparator<Pair>(){

                public int compare(Pair o1,Pair o2){
                    return Integer.compare(o1.r,o2.r);
                }
            });
            Arrays.sort(programming,new Comparator<Pair>(){

                public int compare(Pair o1,Pair o2){
                    return Integer.compare(o1.l,o2.l);
                }
            });
            if(chess[0].r<programming[m-1].l) distance=programming[m-1].l-chess[0].r;
            Arrays.sort(chess,new Comparator<Pair>(){

                public int compare(Pair o1,Pair o2){
                    return Integer.compare(o1.l,o2.l);
                }
            });
            Arrays.sort(programming,new Comparator<Pair>(){

                public int compare(Pair o1,Pair o2){
                    return Integer.compare(o1.r,o2.r);
                }
            });
            if(programming[0].r<chess[n-1].l) distance=Math.max(chess[n-1].l-programming[0].r,distance);
            out.println(distance);
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

    static class Pair{
        int l;
        int r;

        public Pair(int l,int r){
            this.l=l;
            this.r=r;
        }

    }
}

