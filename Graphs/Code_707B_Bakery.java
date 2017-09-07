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
public class Code_707B_Bakery{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _707B_ solver=new _707B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _707B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), m=in.nextInt(), k=in.nextInt();
            ArrayList<Pair>[] graph=new ArrayList[n];
            for(int i=0;i<n;++i) graph[i]=new ArrayList<>();
            while(m-->0){
                int u=in.nextInt()-1, v=in.nextInt()-1, l=in.nextInt();
                graph[u].add(new Pair(v,l));
                graph[v].add(new Pair(u,l));
            }
            boolean[] factories=new boolean[n];
            while(k-->0) factories[in.nextInt()-1]=true;
            int minimum=Integer.MAX_VALUE;
            for(int i=0;i<n;++i){
                if(graph[i].size()>0 && factories[i]){
                    for(Pair p : graph[i]){
                        if(!factories[p.vertex]) minimum=Math.min(minimum,p.weight);
                    }
                }
            }
            out.print(minimum!=Integer.MAX_VALUE?minimum:-1);
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

    static class Pair{
        int vertex;
        int weight;

        public Pair(int vertex,int weight){
            this.vertex=vertex;
            this.weight=weight;
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
}

