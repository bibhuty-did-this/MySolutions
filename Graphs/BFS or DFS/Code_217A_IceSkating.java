import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_217A_IceSkating{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _217A_ solver=new _217A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _217A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            ArrayList<Integer>[] x=new ArrayList[1000];
            ArrayList<Integer>[] y=new ArrayList[1000];
            for(int i=0;i<1000;++i){
                x[i]=new ArrayList<>();
                y[i]=new ArrayList<>();
            }
            int xi, yi;
            for(int i=0;i<n;++i){
                xi=in.nextInt()-1;
                yi=in.nextInt()-1;
                x[xi].add(yi);
                y[yi].add(xi);
            }
            boolean[] traversedX=new boolean[1000];
            boolean[] traversedY=new boolean[1000];
            int total=0, sets=0;
            Queue<Integer> forX=new ArrayDeque<>();
            Queue<Integer> forY=new ArrayDeque<>();
            for(int x_idx=0;x_idx<1000 && total<n;++x_idx){
                if(x[x_idx].size()>0 && !traversedX[x_idx]){
                    ++sets;
                    forX.add(x_idx);
                    while(!forX.isEmpty() || !forY.isEmpty()){
                        if(!forX.isEmpty()){
                            while(!forX.isEmpty()){
                                int getX=forX.poll();
                                if(!traversedX[getX]){
                                    for(int v : x[getX]){
                                        if(!traversedY[v]){
                                            forY.add(v);
                                            ++total;
                                        }
                                    }
                                    traversedX[getX]=true;
                                }
                            }
                        }else if(!forY.isEmpty()){
                            while(!forY.isEmpty()){
                                int getY=forY.poll();
                                if(!traversedY[getY]){
                                    for(int v : y[getY]){
                                        if(!traversedX[v]){
                                            forX.add(v);
                                            ++total;
                                        }
                                    }
                                    traversedY[getY]=true;
                                }
                            }
                        }
                    }
                }
            }
            out.print(sets-1);
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

        public void print(int i){
            writer.print(i);
        }

    }
}

