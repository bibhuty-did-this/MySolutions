import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
public class Code_639A_BearAndDisplayedFriends{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _639A_ solver=new _639A_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _639A_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), k=in.nextInt(), q=in.nextInt(), t[]=in.nextIntArray(n);
            boolean[] isOnline=new boolean[n+1];
            int[] online=new int[k];
            Arrays.fill(online,-1);
            int buffer=0;
            while(q-->0){
                int type=in.nextInt(), id=in.nextInt()-1;
                //out.println("type = ",type," -- id = ",id);
                if(type==1){
                    if(buffer==k){
                        //out.println("Buffer is full");
                        int min_idx=-1;
                        int min=Integer.MAX_VALUE;
                        for(int i=0;i<k;++i){
                            if(t[online[i]]<min){
                                min=t[online[i]];
                                min_idx=i;
                            }
                        }
                        //out.println("t[id] = ",t[id]," t[online[min_idx]] =  ",t[online[min_idx]]);
                        if(t[id]>t[online[min_idx]]){
                            isOnline[online[min_idx]]=false;
                            online[min_idx]=id;
                            isOnline[id]=true;
                        }
                    }else{
                        //out.println("Buffer is not full");
                        for(int i=0;i<k;++i){
                            if(online[i]==-1){
                                //out.println("i = ",i," id = ",id);
                                online[i]=id;
                                break;
                            }
                        }
                        ++buffer;
                        isOnline[id]=true;
                    }
                }else{
                    if(isOnline[id]) out.println("YES");
                    else out.println("NO");
                }
            }
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

        public void println(Object... objects){
            print(objects);
            writer.println();
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

        public int[] nextIntArray(int n){
            int[] array=new int[n];
            for(int i=0;i<n;++i) array[i]=nextInt();
            return array;
        }

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

