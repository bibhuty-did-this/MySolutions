//750A : NEW YEAR AND HURRY
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
			
			//Declare all the necessary variables
			int n=in.nextInt();
			int k=in.nextInt();
			int time=240-k;
			int i=1,problems=0;
			
			//Evaluation of the problem
			/*
			 * - Calculate the remaining time and
			 * deduct the time taken to solve a
			 * problem starting from the first one.
			 * - Take care of the necessary constrains
			 * also.
			 */
			while(time>=(5*i) && problems<n){
				time-=(5*i);
				++i;
				++problems;
			}
			
			//Displaying of the result
			System.out.println(problems);
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
