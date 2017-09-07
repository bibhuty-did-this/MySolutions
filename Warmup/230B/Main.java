//230B : T-PRIMES
/*
 * Solution: http://codeforces.com/contest/230/submission/23770580
 */
/*
 * Prerequisite:
 * 	- Sieve of Eratosthenes
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//Your code goes here
public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			//Define and take inputs of required variables
			int n=in.nextInt();
			long[] num=new long[n];
			for(int i=0;i<n;++i)num[i]=in.nextLong();
			
			//Compute and display the result
			/*
			 * As per the question it can be said that
			 * we will get those numbers as T-primes 
			 * which are the square of odd numbers. And
			 * as the max number can be 10e12 so the 
			 * max sqrt will be 10e6.
			 * 
			 * So the logic behind this is to design a 
			 * lookup table where we could find whether
			 * the square root of the number is a prime 
			 * number or not in O(1) time. Also the time
			 * complexity of the program is O(n*sqrt(n)). 
			 */
			
			//Define boolean for the lookup table
			boolean[] root=new boolean[1000001];
			
			//Assign the prime numbers as true in the
			//lookup table
			root[2]=true;
			for(int i=3;i<1000001;i+=2)root[i]=isPrime(i);
			
			//Calculation and display of the result
			for(int i=0;i<n;++i){
				/*
				 * If a number is even and it is not 4
				 * then we are sure that it must have
				 * at least 4 divisors as 1,2, the number 
				 * itself & (the number/2). Exception is
				 * the number 2 which is taken care of.
				 */
				if(num[i]%2==0 && num[i]!=4){
					System.out.println("NO");
					continue;
				}
				
				
				double res=Math.sqrt(num[i]);
				/*
				 * If a number's square root has a 
				 * fractional part then it is sure 
				 * that it is not the square of any
				 * prime, so the case is rejected
				 */
				if(res%1!=0){
					System.out.println("NO");
					continue;
				}
				
				/*
				 * Here we take care of the case where 
				 * even if a number have an integral 
				 * square root whether it is a prime or
				 * not. 
				 */
				if(root[(int)res])System.out.println("YES");
				else System.out.println("NO");
			}
			
			
		}
		boolean isPrime(int n){
			for(int i=3;i*i<=n;i+=2)if(n%i==0)return false;
			return true;
		}
	}
	
	//Default template for all the codes
	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream),32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong(){
        	return Long.parseLong(next());
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
	
	//Template.Main method for all the codes
	public static void main(String[] args) {
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
		ProblemSolver problemSolver = new ProblemSolver();
		problemSolver.solveTheProblem(in, out);		
		out.close();		
	}

}
