//37A : TOWERS

/*
 * Solution: http://codeforces.com/contest/37/submission/23790032
 */

/*
 * Prerequisite:
 * 	- Concept of lookup table
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
			//Declare the variables and take necessary inputs &
			//simultaneously evaluate for the result
			/*
			 * Initialize a lookup table with the length near to 1000
			 * as the size of the sticks can't be more than 1000.
			 * 
			 * Initialize 2 variables:
			 * 	1. height: to take care of the maximum height
			 * 	2. extra: to take care of number of sticks which are 
			 *            used for building the tower
			 *  
			 *  In each step of input check whether the length of the
			 *  tower exists or not. If it exists then increment extra 
			 *  and also check whether that tower has the maximum length
			 *  or not 
			 */
			int n=in.nextInt();
			int[] table=new int[1001];
			int extra=0;
			int height=0;
			for(int i=0;i<n;++i){
				int len=in.nextInt();
				if(table[len]!=0)++extra;
				++table[len];
				height=Math.max(height, table[len]);
			}
			System.out.println(height+" "+(n-extra));
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
