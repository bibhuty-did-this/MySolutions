//706A : BERU-TAXI


/*
 * Solution: https://github.com/bibhuty/Codeforces/blob/master/706A/Main.java
 */


/*
 * Prerequisite:
 * 	- Basic Mathematic(Distance formula)
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
			
			//Inputs: Origin, Number of taxis
			int x0=in.nextInt(),y0=in.nextInt(),n=in.nextInt();
			double min=Integer.MAX_VALUE;//Initialization of answer
			
			//Compare each timing for the minimum value
			while(n-- > 0){
				int x=in.nextInt();
				int y=in.nextInt();
				int v=in.nextInt();
				min= Math.min((double)min, Math.sqrt(Math.pow(x-x0, 2)+Math.pow(y-y0, 2))/v);			
			}	
			
			//Display the result
			out.printf("%f", min);
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
