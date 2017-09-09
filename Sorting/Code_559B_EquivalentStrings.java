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
public class Code_559B_EquivalentStrings{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _559B_ solver=new _559B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _559B_{
        /**
         * Time complexity: O(nlog n)
         *
         * Here we need to divide the string into 2 halves till that portion until
         * we get a part such that which is not divisible further
         *
         * We need to compare a1,a2 and b1,b2 or a1,b2 and a2,b1 because in the input
         * we don't have the string organized in a particular order. If we organize the
         * string in a paricular order such that after each division the first half is
         * always lexicographically larger than the second half then our work is done.
         * So we use finalString function to do the same which in turn takes log n time
         * to do the housekeeping stuffs
         *
         * After housekeeping is done its a matter of linear time i.e. O(n)to check whether
         * the strings are equivalent or not.
         *
         * So total time is O(nlog n)
         */
        public void solve(int testNumber,InputReader in,OutputWriter out){
            String a=finalString(in.next());
            String b=finalString(in.next());
            if(a.compareTo(b)==0) out.print("YES");
            else out.print("NO");
        }

        public String finalString(String s){
            int length=s.length();
            if(length%2==1) return s;
            String a=finalString(s.substring(0,length/2));
            String b=finalString(s.substring(length/2));
            if(a.compareTo(b)<0) return a+b;
            else return b+a;
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

        public String nextString(){
            int c=read();
            while(isSpaceChar(c)){
                c=read();
            }
            StringBuilder res=new StringBuilder();
            do{
                if(Character.isValidCodePoint(c)){
                    res.appendCodePoint(c);
                }
                c=read();
            }while(!isSpaceChar(c));
            return res.toString();
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

        public String next(){
            return nextString();
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

