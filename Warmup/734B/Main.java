//734B : ANTON AND DIGITS

/*
 * Solution: http://codeforces.com/contest/734/submission/23790960
 */

/*
 * Prerequisite:
 * 	- Logical Reasoning
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
			//Take the necessary inputs
			int k2=in.nextInt(),k3=in.nextInt(),k5=in.nextInt(),k6=in.nextInt();
			
			/*
			 * Total number of 256 possible = min(k2,k5,k6)
			 * Total number or 2 present after that= k2-min(k2,k5,k6)
			 */
			int _256=Math.min(k2, Math.min(k5, k6));			
			k2-=_256;
			
			/*
			 * Total number of 32 possible = min(k2,k3)
			 */
			int _32=Math.min(k2, k3);
			
			//Display the result
			System.out.println((_256*256)+(_32*32));
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
