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
public class Code_17A_NoldbachProblem{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _17A_ solver=new _17A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _17A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int primes[]={
                    2,3,5,7,11,13,17,19,23,29,31,37,41,
                    43,47,53,59,61,67,71,73,79,83,89,97,101,
                    103,107,109,113,127,131,137,139,149,151,157,163,167,
                    173,179,181,191,193,197,199,211,223,227,229,233,239,
                    241,251,257,263,269,271,277,281,283,293,307,311,313,
                    317,331,337,347,349,353,359,367,373,379,383,389,397,
                    401,409,419,421,431,433,439,443,449,457,461,463,467,
                    479,487,491,499,503,509,521,523,541,547,557,563,569,
                    571,577,587,593,599,601,607,613,617,619,631,641,643,
                    647,653,659,661,673,677,683,691,701,709,719,727,733,
                    739,743,751,757,761,769,773,787,797,809,811,821,823,
                    827,829,839,853,857,859,863,877,881,883,887,907,911,
                    919,929,937,941,947,953,967,971,977,983,991,997};
            int length=primes.length;
            int[] sums=new int[length-1];
            boolean[] present=new boolean[2000];
            for(int i=0;i<length-1;++i)
                present[primes[i]+primes[i+1]+1]=true;
            int n=in.nextInt(), total=0;
            for(int prime : primes)
                if(prime<=n&&present[prime])
                    ++total;
            out.print(total>=in.nextInt()?"YES":"NO");
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

