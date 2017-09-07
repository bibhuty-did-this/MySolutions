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
public class Code_722B_VersePattern{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _722B_ solver=new _722B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _722B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), a[]=in.nextIntArray(n);
            for(int i=0;i<n;++i){
                String s=in.readLine();
                int vowels=0;
                for(int j=0;j<s.length();++j){
                    char c=s.charAt(j);
                    if(isVowel(c)) ++vowels;
                }
                if(vowels!=a[i]){
                    out.print("NO");
                    return;
                }
            }
            out.print("YES");
        }

        public boolean isVowel(char c){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y') return true;
            return false;
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

        private String readLine0(){
            StringBuilder buf=new StringBuilder();
            int c=read();
            while(c!='\n'&&c!=-1){
                if(c!='\r'){
                    buf.appendCodePoint(c);
                }
                c=read();
            }
            return buf.toString();
        }

        public String readLine(){
            String s=readLine0();
            while(s.trim().length()==0){
                s=readLine0();
            }
            return s;
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

