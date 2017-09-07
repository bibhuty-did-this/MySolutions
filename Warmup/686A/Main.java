//686A : FREE ICE CREAM


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Basic mathematics
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
			//Take the necessary inputs
			int n=in.nextInt();
			long total=in.nextInt();
			int distress=0;
			
			//Evaluate for the result
			/*
			 * Algorithm:
			 * 	- Evaluate with each inputs depending on +/-
			 */
			while(n-- > 0){
				String sign=in.next();
				int num=in.nextInt();
				if(sign.charAt(0)=='+')total+=num;
				else{
					if(num>total)++distress;
					else total-=num;
				}
			}
			out.print(total+" "+distress);
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
