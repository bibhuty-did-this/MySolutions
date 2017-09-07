//705 A: HULK

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//Template.Main function
public class Main {		
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			
			//Getting input from the user
			int n=in.nextInt();
			
			//Printing in a smart manner
			for(int i=1;i<=n;++i){
				if(i%2==1){
					if(i!=n)System.out.print("I hate that ");
					else System.out.print("I hate ");
				}else{
					if(i!=n)System.out.print("I love that ");
					else System.out.print("I love ");
				}
			}
			System.out.println("it");
		}					
	}
	
	//Default template for all the codes for optimized input and output
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
