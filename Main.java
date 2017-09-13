//#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
//#parse("File Header.java")]


import javafx.util.Pair;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main{

    static class ProblemSolver{
        public void solveTheProblem(InputReader in,OutputWriter out){

        }
    }

    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        ProblemSolver problemSolver=new ProblemSolver();
        problemSolver.solveTheProblem(in,out);
        out.flush();
        out.close();
    }
    static class InputReader {
        private boolean finished = false;

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(nextString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }

        public String next() {
            return nextString();
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
        public int[] nextIntArray(int n){
            int[] array=new int[n];
            for(int i=0;i<n;++i)array[i]=nextInt();
            return array;
        }
        public int[] nextSortedIntArray(int n){
            int array[]=nextIntArray(n);
            Arrays.sort(array);
            return array;
        }
        public int[] nextSumIntArray(int n){
            int[] array=new int[n];
            array[0]=nextInt();
            for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
            return array;
        }
        public long[] nextLongArray(int n){
            long[] array=new long[n];
            for(int i=0;i<n;++i)array[i]=nextLong();
            return array;
        }
        public long[] nextSumLongArray(int n){
            long[] array=new long[n];
            array[0]=nextInt();
            for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
            return array;
        }
        public long[] nextSortedLongArray(int n){
            long array[]=nextLongArray(n);
            Arrays.sort(array);
            return array;
        }
        public int[][] nextIntMatrix(int n,int m){
            int[][] matrix=new int[n][m];
            for(int i=0;i<n;++i)
                for(int j=0;j<m;++j)
                    matrix[i][j]=nextInt();
            return matrix;
        }

        public int[][] nextIntMatrix(int n){
            return nextIntMatrix(n,n);
        }

        public long[][] nextLongMatrix(int n,int m){
            long[][] matrix=new long[n][m];
            for(int i=0;i<n;++i)
                for(int j=0;j<m;++j)
                    matrix[i][j]=nextLong();
            return matrix;
        }

        public long[][] nextLongMatrix(int n){
            return nextLongMatrix(n,n);
        }

        public char[][] nextCharMatrix(int n,int m){
            char[][] matrix=new char[n][m];
            for(int i=0;i<n;++i)
                matrix[i]=next().toCharArray();
            return matrix;
        }

        public char[][] nextCharMatrix(int n){
            return nextCharMatrix(n,n);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(char[] array) {
            writer.print(array);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void print(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void print(double[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void print(char[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void print(String[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void print(int[][] matrix){
            for(int i=0;i<matrix.length;++i){
                println(matrix[i]);
            }
        }

        public void print(double[][] matrix){
            for(int i=0;i<matrix.length;++i){
                println(matrix[i]);
            }
        }

        public void print(long[][] matrix){
            for(int i=0;i<matrix.length;++i){
                println(matrix[i]);
            }
        }

        public void print(char[][] matrix){
            for(int i=0;i<matrix.length;++i){
                println(matrix[i]);
            }
        }

        public void print(String[][] matrix){
            for(int i=0;i<matrix.length;++i){
                println(matrix[i]);
            }
        }

        public void println(int[] array) {
            print(array);
            writer.println();
        }

        public void println(double[] array) {
            print(array);
            writer.println();
        }

        public void println(long[] array) {
            print(array);
            writer.println();
        }

        public void println(char[] array) {
            print(array);
            writer.println();
        }

        public void println(String[] array) {
            print(array);
            writer.println();
        }

        public void println() {
            writer.println();
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void print(char i) {
            writer.print(i);
        }

        public void println(char i) {
            writer.println(i);
        }

        public void println(char[] array) {
            writer.println(array);
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

        public void print(long i) {
            writer.print(i);
        }

        public void println(long i) {
            writer.println(i);
        }

        public void print(int i) {
            writer.print(i);
        }

        public void println(int i) {
            writer.println(i);
        }

        public void separateLines(int[] array) {
            for (int i : array) {
                println(i);
            }
        }
    }
    class NumberTheory{

        /**
         * Modular Arithmetic:
         *  1. (a+b)%c=(a%c+b%c)%c
         *  2. (a*b)%c=(a%c*b%c)%c
         *  3. (a-b)%c=(a%c-b%c+c)%c
         *  4. (a/b)%c=(a%c*(b^-1)%c)%c -- (b^-1 is multiplicative modulo inverse)
         */
        //Modular Addition
        public int modularAddition(int a,int b,int MOD){
            return (a%MOD+b%MOD)%MOD;
        }
        public long modularAddition(long a,long b,long MOD){
            return (a%MOD+b%MOD)%MOD;
        }
        //Modular Multiplication
        public int modularMultiplication(int a,int b,int MOD){
            return ((a%MOD)*(b%MOD))%MOD;
        }
        public long modularMultiplication(long a,long b,long MOD){
            return ((a%MOD)*(b%MOD))%MOD;
        }
        //Modular Subtraction
        public int modularSubtraction(int a,int b,int MOD){
            return (a%MOD-b%MOD+MOD)%MOD;
        }
        public long modularSubtraction(long a,long b,long MOD){
            return (a%MOD-b%MOD+MOD)%MOD;
        }

        /**
         * Binary Exponentiation
         */
        public int binaryExponentiation(int x,int n){
            if(n==0)return 1;
            else if(n%2==0)return binaryExponentiation(x*x,n/2);
            else return x*binaryExponentiation(x*x,(n-1)/2);
        }
        public long binaryExponentiation(long x,long n){
            long result=1;
            while(n>0){
                if(n%2==1)result*=x;
                x=x*x;
                n/=2;
            }
            return result;
        }

        /**
         * Modular Exponentiation
         */
        public int modularExponentiation(int x,int n,int MOD){
            if(n==0)return 1%MOD;
            else if(n%2==0)return modularExponentiation(modularMultiplication(x,x,MOD),n/2,MOD);
            else return modularMultiplication(x,modularExponentiation(modularMultiplication(x,x,MOD),(n-1)/2,MOD),MOD);
        }
        public long modularExponentiation(long x,long n,long MOD){
            long result=1;
            while(n>0){
                if(n%2==1)result=modularMultiplication(result,x,MOD);
                x=modularMultiplication(x,x,MOD);
                n/=2;
            }
            return result;
        }

        /**
         * Factorial of a number
         */
        public long factorials(long n){
            if(n==0)return 1;
            return n*factorials(n-1);
        }

        /**
         * Prime factors of a number
         */
        public ArrayList<Integer> distinctPrimeFactors(int n){
            ArrayList<Integer> factorials=new ArrayList<>();
            int limit=(int)Math.sqrt(n);
            if(n%2==0){
                factorials.add(2);
                while(n%2==0)n/=2;
            }
            for(int i=3;i<=limit;i+=2){
                if(n%i==0){
                    factorials.add(i);
                    while(n%i==0)n/=i;
                }
            }
            if(n>2)factorials.add(n);
            return factorials;
        }

        public ArrayList<Long> distinctPrimeFactors(long n){
            ArrayList<Long> factorials=new ArrayList<>();
            long limit=(long)Math.sqrt(n);
            if(n%2==0){
                factorials.add((long)2);
                while(n%2==0)n/=2;
            }
            for(long i=3;i<=limit;i+=2){
                if(n%i==0){
                    factorials.add(i);
                    while(n%i==0)n/=i;
                }
            }
            if(n>2)factorials.add(n);
            return factorials;
        }

        public ArrayList<Integer> primeFactors(int n){
            ArrayList<Integer> factorials=new ArrayList<>();
            int limit=(int)Math.sqrt(n);
            if(n%2==0){
                factorials.add(2);
                while(n%2==0)n/=2;
            }
            for(int i=3;i<=limit;i+=2){
                if(n%i==0){
                    factorials.add(i);
                    while(n%i==0)n/=i;
                }
            }
            if(n>2)factorials.add(n);
            return factorials;
        }

        public ArrayList<Long> primeFactors(long n){
            ArrayList<Long> factorials=new ArrayList<>();
            long limit=(long)Math.sqrt(n);
            if(n%2==0){
                factorials.add((long)2);
                while(n%2==0)n/=2;
            }
            for(long i=3;i<=limit;i+=2){
                if(n%i==0){
                    factorials.add(i);
                    while(n%i==0)n/=i;
                }
            }
            if(n>2)factorials.add(n);
            return factorials;
        }

        /**
         * Combination: nCr
         */
        //Naive version
        //(n,r)=(n-1,r-1)+(n-1,r) for r!=0 or r!=n
        //(n,0)=(n,n)=1
        public int binomialCoefficientRecursive(int n,int k){
            if(k==0 || k==n)return 1;//base case
            return binomialCoefficientRecursive(n-1,k-1)+binomialCoefficientRecursive(n-1,k);//recursion
        }

        //Dynamic Programming version(Uses bottom up approach to fill the table)
        //Time complexity: O(n*k)
        //Space complexity: O(n*k)
        public long binomialCoefficientIterative(int n,int k){
            long[][] C=new long[n+1][k+1];
            for(int i=0;i<=n;++i){
                for(int j=0;j<=Math.min(n,k);++j){
                    if(j==0 || j==i)C[i][j]=1;
                    else C[i][j]=C[i-1][j-1]+C[i-1][j];
                }
            }
            return C[n][k];
        }

        //Pascal's Triangle version(Space efficient program)
        //Time complexity: O(n*k)
        //Space complexity: O(k)
        public long nCr(int n,int r){
            int[] C=new int[r+1];
            C[0]=1;//nC0=1
            for(int i=1;i<=n;++i)
                for(int j=Math.min(i,r);j>0;--j)
                    C[j]=C[j]+C[j-1];
            return C[r];
        }

        /**
         * Catlan number:
         *  - Time complexity: O(n*n)
         *  - Auxiliary space: O(n)
         *
         *  NOTE: Time complexity could be reduced to O(n) but it is
         *        possible if and only if n is small or else there is
         *        a chance of getting an overflow. To decrease the time
         *        complexity to O(n) just remember nCr=nCn-r
         */
        public long catlanNumber(int n){
            long[] catlan=new long[n+1];
            catlan[0]=catlan[1]=1;
            for(int i=2;i<=n;++i)
                for(int j=0;j<i;++j)
                    catlan[i]+=catlan[j]*catlan[i-1-j];

            return catlan[n];
        }

        /**
         * Greatest Common Divisor(GCD)
         *  - It is also known as Highest Common Factor(HCF)
         *  - Time complexity: log(min(a,b))
         *  - Auxiliary Space: O(1)
         */
        public int gcd(int a,int b){
            if(b==0)return a;
            return gcd(b%a,a);
        }

        public long gcd(long a,long b){
            if(b==0)return a;
            return gcd(b%a,a);
        }

        /**
         * Extended Euclid's Algorithm:
         *  - ax+by=gcd(a,b)
         *  - Time complexity:
         *  -
         */

        public Pair<Integer,Integer> extendedEuclid(int a,int b){
            int x=0,y=1, lastx = 1, lasty = 0, temp;
            while (b != 0){
                int q=a/b;
                int r=a%b;

                a=b;
                b=r;

                temp=x;
                x=lastx-q*x;
                lastx=temp;

                temp=y;
                y=lasty-q*y;
                lasty=temp;
            }

            return new Pair<>(x,y);
        }

        public Pair<Long,Long> extendedEuclid(long a,long b){
            long x=0,y=1, lastx = 1, lasty = 0, temp;
            while (b != 0){
                long q=a/b;
                long r=a%b;

                a=b;
                b=r;

                temp=x;
                x=lastx-q*x;
                lastx=temp;

                temp=y;
                y=lasty-q*y;
                lasty=temp;
            }

            return new Pair<>(x,y);
        }

        /**
         * Least Common Multiple(LCM):
         *  - Time complexity: log(min(a,b))
         *  - Auxiliary Space: O(1)
         */
        public long lcm(long a,long b){
            return (a*b)/gcd(a,b);
        }

    }
}
