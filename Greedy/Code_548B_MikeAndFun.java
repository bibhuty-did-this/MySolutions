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
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_548B_MikeAndFun{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _548B_ solver=new _548B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _548B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), m=in.nextInt(), q=in.nextInt();
            int[][] bears=new int[n][m];
            ArrayList<Data> score=new ArrayList<>();
            for(int i=0;i<n;score.add(new Data(i++)))
                for(int j=0;j<m;bears[i][j++]=in.nextInt()) ;
            for(int i=0, cur=0, ans=0;i<n;score.get(i++).increment(ans),cur=0,ans=0)
                for(int j=0;j<m;++j,ans=Math.max(cur,ans))
                    cur+=(bears[i][j]==1?1:-1*cur);
            while(q-->0){
                int i=in.nextInt()-1, j=in.nextInt()-1;
                bears[i][j]=(bears[i][j]==0?1:0);
                int ans=0;
                for(int k=0, cur=0;k<m;ans=Math.max(ans,cur+=(bears[i][k++]==1?1:-1*cur))) ;
                score.get(i).reset();
                score.get(i).increment(ans);
                Collections.sort(score,Comparator.comparingInt(o->o.elements));
                out.println(score.get(n-1).elements);
                Collections.sort(score,Comparator.comparingInt(o->o.index));
            }

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

    static class Data{
        int index;
        int elements;

        public Data(int index){
            this.index=index;
            this.elements=0;
        }

        public void increment(int inc){
            this.elements+=inc;
        }

        public void reset(){
            this.elements=0;
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
}

