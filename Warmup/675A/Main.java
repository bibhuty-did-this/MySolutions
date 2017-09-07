//675A : INFINITE SEQUENCE


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Modular Arithematic
 * 	- The range of float and double(as the answer 
 * 	  will give error if taken float)
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
			double a=in.nextInt(),
				   b=in.nextInt(),
				   c=in.nextInt();
			
			//Evaluate and display the results
			/* Base Case */
			if(c==0){
				if(a==b){
					out.print("YES");
					return;
				}else{
					out.print("NO");
					return;					
				}
			}
			
			/*Usual Case*/
			double ans=(b-a)/c;
			if(ans<0 || ans%1!=0)out.print("NO");
			else out.print("YES");
			
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
