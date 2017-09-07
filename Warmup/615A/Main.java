//615A: BULBS

/*
 * Solution: http://ideone.com/AG0HPd
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
			//Take the necessary inputs and solve the problem
			/*
			 * Idea:
			 * - Here we need to keep track of a lookup table to 
			 *   keep track of number of lights turned on along
			 *   with a counter variable which increments with each
			 *   turning on of the light
			 */
			int n=in.nextInt();
			int m=in.nextInt();
			int on=0;
			boolean[] table=new boolean[m+1];
			for(int i=0;i<n;++i){
				int counter=in.nextInt();
				while(counter-->0){
					int idx=in.nextInt();
					if(!table[idx]){
						table[idx]=true;
						++on;
					}
				}
			}
			if(on==m)out.print("YES");
			else out.println("NO");
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
