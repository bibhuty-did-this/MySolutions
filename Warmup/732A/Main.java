//732A : BUY A SHOVEL

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
			
			//Take the necessary inputs from the user
			int k=in.nextInt();
			int r=in.nextInt();
			
			/*
			 * Initialize the result variable as 10
			 * as it could not be more than 10 which
			 * could be clearly seen in the question
			 */
			int result=10;
			
			//For loop for the brute force check
			for(int i=1;i<10;++i){
				if((k*i)%10==0 ||((k*i)-r)%10==0){
					result=i;
					break;
				}				
			}
			
			//Print the result
			System.out.println(result);
			
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
