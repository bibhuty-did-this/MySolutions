import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class CHEFSUBA{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _CHEFSUBA_ solver=new _CHEFSUBA_();
        solver.solve(1,in,out);
        out.close();
    }

    static class _CHEFSUBA_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), k=in.nextInt(), p=in.nextInt();
            if(k>n) k=n;
            int[] binary=new int[n];
            for(int i=0;i<n;++i) binary[i]=in.nextInt();
            int[] array=new int[n];
            int[] evaluated=new int[n];
            Arrays.fill(evaluated,-1);
            for(int i=0;i<k;++i) array[0]+=binary[i];
            for(int i=1;i<n;++i)
                array[i]=(array[i-1]-binary[i-1])+binary[(i+(k-1))%n];
            //out.print(array);
            String s=in.next();
            SegmentTree segmentTree=new SegmentTree(array);
            //segmentTree.print();
            int pointer=0;
            for(int i=0;i<p;++i){
                if(s.charAt(i)=='!'){
                    if(pointer==0) pointer=n-1;
                    else --pointer;
                }else{
                    if(evaluated[pointer]==-1){
                        if(pointer>=k){
                            evaluated[pointer]=Math.max(segmentTree.getMax(pointer,n-1),segmentTree.getMax(0,(pointer+n-k)%n));
                            out.println(evaluated[pointer]);
                        }else{
                            evaluated[pointer]=segmentTree.getMax(pointer,pointer+n-k);
                            out.println(evaluated[pointer]);
                        }
                    }else out.println(evaluated[pointer]);
                }
            }
        }

    }

    static class InputReader{
        private InputStream stream;
        private byte[] buf=new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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

    static class SegmentTree{
        int[] segmentTree;
        int[] array;
        int n;

        public SegmentTree(int array[]){
            this.array=array;
            this.n=array.length;
            int height=(int)Math.ceil(Math.log(n)/Math.log(2));
            int numberOfNodes=2*(int)Math.pow(2,height)-1;
            segmentTree=new int[numberOfNodes];
            constructSegmentTree(0,n-1,0);
        }

        int constructSegmentTree(int arrayBegin,int arrayEnd,int treeIndex){
            if(arrayBegin==arrayEnd){
                segmentTree[treeIndex]=array[arrayBegin];
                return segmentTree[treeIndex];
            }
            int arrayMid=(arrayBegin+arrayEnd)/2;
            segmentTree[treeIndex]=Math.max(constructSegmentTree(arrayBegin,arrayMid,2*treeIndex+1),
                    constructSegmentTree(arrayMid+1,arrayEnd,2*treeIndex+2));
            return segmentTree[treeIndex];
        }

        int getMaxUtility(int arrayBegin,int arrayEnd,int queryBegin,int queryEnd,int treeIndex){
            if(queryBegin<=arrayBegin && arrayEnd<=queryEnd)
                return segmentTree[treeIndex];
            if(queryEnd<arrayBegin || arrayEnd<queryBegin)
                return 0;
            int arrayMid=(arrayBegin+arrayEnd)/2;
            return Math.max(getMaxUtility(arrayBegin,arrayMid,queryBegin,queryEnd,2*treeIndex+1),
                    getMaxUtility(arrayMid+1,arrayEnd,queryBegin,queryEnd,2*treeIndex+2));
        }

        int getMax(int queryBegin,int queryEnd){
            if(queryBegin<0 || queryEnd>n-1 || queryBegin>queryEnd)
                return -1;
            return getMaxUtility(0,n-1,queryBegin,queryEnd,0);
        }

    }
}

