//560A : CURRENCY SYSTEM IN GERALDION

/*
 * Solution: http://codeforces.com/contest/560/submission/23772242
 */

/*
 * Prerequisite:
 * 	- Logical thinking 
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
			//Take the necessary inputs and compute the result simulatneously
			/*
			 * In order to represent any positive number the only
			 * number `1` is more than sufficient. So this question
			 * reduces to the question where we are supposed to find 
			 * whether there is `1` present in the inputs or not.
			 * 
			 * If `1` is present it could be used to represent any 
			 * number. So the answer will be -1 else the answer will
			 * be `1` as it is the smallest positive number
			 */
			int n=in.nextInt();
			boolean one=false;
			while(n-->0){
				int input=in.nextInt();
				if(input==1){
					one=true;
					break;
				}
			}
			
			//Display of result
			if(one)System.out.println("-1");
			else System.out.println("1");			
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
