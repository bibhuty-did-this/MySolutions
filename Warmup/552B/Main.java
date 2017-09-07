//552B : VANYA AND BOOKS


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Simple Math
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			/*
			 * Algorithm:
			 * 	- We know that numbers of 2 digits, 3 digits ...
			 *    ends with 9, 99 .....
			 *  - If u understand the following formula then it is done:
			 *    	~ Total number of digits with digits n below
			 *    			10eN = N*(10eN-10e(N-1)) 
			 *        with an exception for N=1
			 *      ~ For the case where the number is not exactly in
			 *        this format find the next such format and find 
			 *        the answer by replacing the value with the 10eN 
			 *        of RHS of the above formula
			 */
			
			//Take the necessary inputs
			int n=in.nextInt();
			
			//Declare the necessary variables and evaluate
			long ans=0,digit=1;
			int sub=0;
			while(true){
				if(n<Math.pow(10, digit)-1){
					ans+=(n-sub)*(digit);
					break;
				}else{
					ans+=(Math.pow(10, digit)-1-sub)*(digit);
					sub=(int)Math.pow(10, digit)-1;
				}
				++digit;
			}
			
			//Print the result
			out.print(ans);
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
