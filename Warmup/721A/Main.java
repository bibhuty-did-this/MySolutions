//721A : ONE-DIMENSIONAL JAPANESE CROSSWORD
/*
 * Solution: http://codeforces.com/contest/721/submission/23723476
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Your code goes here
public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			//Declare and evaluate all the necessary inputs
			int n=in.nextInt();
			String s=in.next();
			ArrayList<Integer> nums=new ArrayList<>();
			int count=0;
			
			//Evaluate the result
			/*
			 * It is a very simple question where
			 * we need to memorize the number of
			 * B before white and store them in a
			 * list. Also we need to consider the 
			 * case where the last letter could
			 * be a black one. 
			 */
			for(int i=0;i<n;++i){
				if(s.charAt(i)=='B'){
					++count;
					/*
					 * Note:
					 * 	- if(s.charAt(i+1)=='W' || i+1>=n)
					 * 		~ This type of if statement gives 
					 * 		  error as s.charAt(i+1) during
					 * 		  evaluation can give index out
					 *        of bound expression
					 */
					if(i+1>=n || s.charAt(i+1)=='W'){
						nums.add(count);
					}
				}else count=0;
			}
			System.out.println(nums.size());
			for(int no:nums){
				System.out.print(no+" ");
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
