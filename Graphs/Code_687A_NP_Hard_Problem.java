import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
public class Code_687A_NP_Hard_Problem{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _687A_ solver=new _687A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _687A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), m=in.nextInt();
            ArrayList<Integer>[] graph=new ArrayList[n+1];
            ArrayList<Integer> blue=new ArrayList<>();
            ArrayList<Integer> red=new ArrayList<>();
            for(int i=0;i<=n;++i) graph[i]=new ArrayList<>();
            char[] graphColor=new char[n+1];
            Arrays.fill(graphColor,'w');
            while(m-->0){
                int x=in.nextInt(), y=in.nextInt();
                graph[x].add(y);
                graph[y].add(x);
            }
            Queue<Integer> vertices=new ArrayDeque<>();
            for(int i=1;i<=n;++i){
                if(graph[i].size()==0) blue.add(i);
                else if(graph[i].size()!=0 && graphColor[i]=='w'){
                    vertices.add(i);
                    graphColor[i]='b';
                    while(!vertices.isEmpty()){
                        int current=vertices.poll();
                        char color='w';
                        if(graphColor[current]=='b'){
                            color='r';
                            blue.add(current);
                        }else if(graphColor[current]=='r'){
                            color='b';
                            red.add(current);
                        }
                        for(int vertex : graph[current]){
                            if(graphColor[vertex]!=graphColor[current]){
                                if(graphColor[vertex]=='w'){
                                    graphColor[vertex]=color;
                                    vertices.add(vertex);
                                }
                            }else if(graphColor[vertex]==graphColor[current]){
                                out.print(-1);
                                return;
                            }
                        }
                    }
                }
            }

            out.println(red.size());
            for(int v : red) out.print(v,"");
            out.println();
            out.println(blue.size());
            for(int v : blue) out.print(v,"");

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

        public void println(){
            writer.println();
        }

        public void close(){
            writer.close();
        }

        public void print(int i){
            writer.print(i);
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
}

