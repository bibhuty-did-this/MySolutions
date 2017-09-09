import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_471B_MuhAndImportantThings{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _471B_ solver=new _471B_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _471B_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt();
            ArrayList<Integer>[] graph=new ArrayList[2001];
            for(int i=0;i<2001;i++){
                graph[i]=new ArrayList<>();
            }
            int three_index=-1;
            int two_index1=-1;
            int two_index2=-1;
            boolean three_found=false;
            boolean two_found=false;
            for(int i=1;i<=n;++i){
                graph[in.nextInt()].add(i);
            }
            for(int i=1;i<=2000;++i){
                if(graph[i].size()==2){
                    if(two_index1==-1) two_index1=i;
                    else if(two_index2==-1){
                        two_index2=i;
                        two_found=true;
                        break;
                    }
                }else if(graph[i].size()>=3){
                    three_index=i;
                    three_found=true;
                    break;
                }
            }
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            StringBuilder sb3=new StringBuilder();
            if(three_found){
                for(int i=0;i<three_index;++i){
                    if(graph[i].size()>0){
                        for(int w : graph[i]){
                            sb1.append(w).append(' ');
                            sb2.append(w).append(' ');
                            sb3.append(w).append(' ');
                        }
                    }

                }

                sb1.append(graph[three_index].get(0)).append(' ');
                sb1.append(graph[three_index].get(1)).append(' ');
                sb1.append(graph[three_index].get(2)).append(' ');

                sb2.append(graph[three_index].get(1)).append(' ');
                sb2.append(graph[three_index].get(2)).append(' ');
                sb2.append(graph[three_index].get(0)).append(' ');

                sb3.append(graph[three_index].get(2)).append(' ');
                sb3.append(graph[three_index].get(0)).append(' ');
                sb3.append(graph[three_index].get(1)).append(' ');

                for(int i=3;i<graph[three_index].size();++i){
                    sb1.append(graph[three_index].get(i)).append(' ');
                    sb2.append(graph[three_index].get(i)).append(' ');
                    sb3.append(graph[three_index].get(i)).append(' ');
                }

                for(int i=three_index+1;i<2001;++i){
                    if(graph[i].size()>0){
                        for(int w : graph[i]){
                            sb1.append(w).append(' ');
                            sb2.append(w).append(' ');
                            sb3.append(w).append(' ');
                        }
                    }
                }

                out.println("YES");
                out.println(sb1.toString());
                out.println(sb2.toString());
                out.println(sb3.toString());

            }else if(two_found){
                int a=two_index1, b=two_index2;
                two_index1=Math.min(a,b);
                two_index2=Math.max(a,b);
                //out.println(two_index1,two_index2);

                for(int i=0;i<two_index1;++i){
                    if(graph[i].size()>0){
                        for(int w : graph[i]){
                            sb1.append(w).append(' ');
                            sb2.append(w).append(' ');
                            sb3.append(w).append(' ');
                        }
                    }

                }

                sb1.append(graph[two_index1].get(0)).append(' ');
                sb1.append(graph[two_index1].get(1)).append(' ');

                sb2.append(graph[two_index1].get(0)).append(' ');
                sb2.append(graph[two_index1].get(1)).append(' ');

                sb3.append(graph[two_index1].get(1)).append(' ');
                sb3.append(graph[two_index1].get(0)).append(' ');

                for(int i=two_index1+1;i<two_index2;++i){
                    if(graph[i].size()>0){
                        for(int w : graph[i]){
                            sb1.append(w).append(' ');
                            sb2.append(w).append(' ');
                            sb3.append(w).append(' ');
                        }
                    }

                }

                sb1.append(graph[two_index2].get(0)).append(' ');
                sb1.append(graph[two_index2].get(1)).append(' ');

                sb2.append(graph[two_index2].get(1)).append(' ');
                sb2.append(graph[two_index2].get(0)).append(' ');

                sb3.append(graph[two_index2].get(1)).append(' ');
                sb3.append(graph[two_index2].get(0)).append(' ');

                for(int i=two_index2+1;i<2001;++i){
                    if(graph[i].size()>0){
                        for(int w : graph[i]){
                            sb1.append(w).append(' ');
                            sb2.append(w).append(' ');
                            sb3.append(w).append(' ');
                        }
                    }

                }


                out.println("YES");
                out.println(sb1.toString());
                out.println(sb2.toString());
                out.println(sb3.toString());

            }else out.print("NO");
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

        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);

        }

    }
}

