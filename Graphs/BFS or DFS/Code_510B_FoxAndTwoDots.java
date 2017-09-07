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
public class Code_510B_FoxAndTwoDots{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _510B_ solver=new _510B_();
        solver.solve(1,in,out);
        out.close();
    }
    static class _510B_{
        int n;
        int m;
        public void solve(int testNumber,InputReader in,OutputWriter out){
            n=in.nextInt();
            m=in.nextInt();
            char[][] grid=new char[n][m];
            for(int i=0;i<n;++i)
                grid[i]=in.next().toCharArray();
            if(isCyclic(grid)) out.print("Yes");
            else out.print("No");
        }
        public boolean isCyclicUtil(char[][] grid,boolean[][] visited,int row,int col,int prevRow,int prevCol,char color){
            if(row<0 || row>=n || col<0 || col>=m || grid[row][col]!=color) return false;
            if(visited[row][col]) return true;
            visited[row][col]=true;
            if(row+1!=prevRow || col!=prevCol)
                if(isCyclicUtil(grid,visited,row+1,col,row,col,color))
                    return true;
            if(row-1!=prevRow || col!=prevCol)
                if(isCyclicUtil(grid,visited,row-1,col,row,col,color))
                    return true;
            if(row!=prevRow || col+1!=prevCol)
                if(isCyclicUtil(grid,visited,row,col+1,row,col,color))
                    return true;
            if(row!=prevRow || col-1!=prevCol)
                if(isCyclicUtil(grid,visited,row,col-1,row,col,color))
                    return true;
            return false;
        }
        public boolean isCyclic(char[][] grid){
            boolean[][] visited=new boolean[n][m];
            for(int i=0;i<n;++i){
                for(int j=0;j<m;++j){
                    if(!visited[i][j]){
                        if(isCyclicUtil(grid,visited,i,j,i,j,grid[i][j]))
                            return true;
                    }
                }
            }
            return false;
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
}

