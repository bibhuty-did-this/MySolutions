//688A : OPPONENTS


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Basic Mathematics
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
			
			//Take the necessary inputs and declare the variables
			int n=in.nextInt();
			n=in.nextInt();
			String present;
			int consecutive=0;
			int count=0;
			
			//Evaluate the expression
			/*
			 * Algorithm:
			 * 	- If a child is absent in any day then increment the 
			 * 	  number of wins
			 *  - Else see whether the numbers of wins till then is the
			 *    maximum or not
			 */
			for(int i=0;i<n;++i){
				present=in.next();
				if(present.contains("0"))++count;
				else{
					consecutive=Math.max(count, consecutive);
					count=0;
				}
			}
			
			//Display the result
			out.print(Math.max(consecutive, count));
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
