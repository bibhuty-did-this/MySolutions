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
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_166A_RankList{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _166A_ solver=new _166A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _166A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), k=in.nextInt();
            ArrayList<Pair> list=new ArrayList<>();
            while(n-->0)
                list.add(new Pair(in.nextInt(),in.nextInt()));
            Collections.sort(list,(o1,o2)->{
                if(o1.solved!=o2.solved) return Integer.compare(o2.solved,o1.solved);
                else return Integer.compare(o1.penaltyTime,o2.penaltyTime);
            });
            int[] ranks=new int[list.size()];
            int rank=1, i=0, total=1;
            int totalSolved=list.get(k-1).solved, totalPenalty=list.get(k-1).penaltyTime, totalTeam=0;
            for(Pair p : list)
                if(p.solved==totalSolved && p.penaltyTime==totalPenalty)
                    ++totalTeam;
            out.print(totalTeam);
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

    static class Pair{
        int solved;
        int penaltyTime;

        public Pair(int solved,int penaltyTime){
            this.solved=solved;
            this.penaltyTime=penaltyTime;
        }

    }
}

