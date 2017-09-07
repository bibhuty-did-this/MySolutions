import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Stack;
import java.util.HashSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_716B_CompleteTheWord{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _716B_ solver=new _716B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _716B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            String s=in.next();
            int n=s.length();
            if(n<26){
                out.print(-1);
                return;
            }
            Set<Character> alphabets=new HashSet<>();
            int[] isPresent=new int[26];
            int gaps=0;
            for(int i=0;i<26;++i){
                if(s.charAt(i)=='?') ++gaps;
                else{
                    ++isPresent[s.charAt(i)-'A'];
                    alphabets.add(s.charAt(i));
                }
            }
            if(alphabets.size()+gaps==26){
                Stack<Character> stack=new Stack<>();
                for(int j=25;j>=0;--j)
                    if(isPresent[j]==0)
                        stack.push((char)('A'+j));
                for(int j=0;j<26;++j){
                    if(s.charAt(j)=='?') out.print(stack.pop());
                    else out.print(s.charAt(j));
                }
                for(int j=26;j<n;++j){
                    if(s.charAt(j)=='?') out.print('B');
                    else out.print(s.charAt(j));
                }
                return;
            }
            for(int i=26;i<n;++i){
                if(s.charAt(i-26)=='?') --gaps;
                else{
                    --isPresent[s.charAt(i-26)-'A'];
                    if(isPresent[s.charAt(i-26)-'A']==0) alphabets.remove(s.charAt(i-26));
                }
                if(s.charAt(i)=='?') ++gaps;
                else{
                    if(isPresent[s.charAt(i)-'A']==0) alphabets.add(s.charAt(i));
                    ++isPresent[s.charAt(i)-'A'];
                }
                if(alphabets.size()+gaps==26){
                    Stack<Character> stack=new Stack<>();
                    for(int j=25;j>=0;--j)
                        if(isPresent[j]==0)
                            stack.push((char)('A'+j));
                    for(int j=0;j<i-26+1;++j){
                        if(s.charAt(j)=='?') out.print('G');
                        else out.print(s.charAt(j));
                    }
                    for(int j=i-26+1;j<=i;++j){
                        if(s.charAt(j)=='?') out.print(stack.pop());
                        else out.print(s.charAt(j));
                    }
                    for(int j=i+1;j<n;++j){
                        if(s.charAt(j)=='?') out.print('G');
                        else out.print(s.charAt(j));
                    }
                    return;
                }
            }
            out.print(-1);
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
            return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
        }

        public String next(){
            return nextString();
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

        public void print(char i){
            writer.print(i);
        }

        public void close(){
            writer.close();
        }

        public void print(int i){
            writer.print(i);
        }

    }
}

