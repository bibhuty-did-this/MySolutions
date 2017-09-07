//749A : BACHGOLD PROBLEM


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Reasoning
 * 	- Concept of prime numbers
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
			//Take the input
			int n=in.nextInt();
			
			//Evaluate the solution
			/*
			 * Algorithm:
			 * 	- A number greater than 2 can be displayes as follows
			 * 		~ number = (2*n) + 3; or
			 * 		~ number = (2*n)
			 */
			if(n%2==0){
				n/=2;
				out.println(n);
				while(n-->0)out.print("2 ");
			}else{
				n/=2;
				n-=1;
				out.println(n+1);
				while(n-->0)out.print("2 ");
				out.print("3");
			}
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
