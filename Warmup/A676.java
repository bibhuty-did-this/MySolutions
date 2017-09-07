package completed;
//676A : NICHOLAS AND PERMUTATION
/*
 * Prerequisite:
 * 	- implementation
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A676 {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			
			//Take the inputs and keep track of the indices of min and max
			int n=in.nextInt();
			int max=0,min=0;
			for(int i=0;i<n;++i){
				int num=in.nextInt();
				if(num==n)max=i;
				if(num==1)min=i;						
			}
			
			//Only 4 cases are possible and we need to find the best of them
			/*
			 * 1: min at beginning
			 * 2: min at end
			 * 3: max at beginning 
			 * 4: min at end
			 */
			out.print(Math.max(Math.max(Math.abs(max-0), Math.abs(max-n+1)), Math.max(Math.abs(min-0), Math.abs(min-n+1))));
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
