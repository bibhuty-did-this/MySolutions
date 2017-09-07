//716A : CRAZY COMPUTER

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
			//Declare the necessary variables
			int n=in.nextInt();
			int words=1;
			int c=in.nextInt();
			int[] num=new int[n];
			for(int i=0;i<n;++i)num[i]=in.nextInt();
			
			//Compute the result
			/*
			 * If the difference is more than c then
			 * the current word will come to the number
			 * of words present i.e. 1 else we need to 
			 * increase the number of words
			 */
			for(int i=1;i<n;++i){
				if(num[i]-num[i-1]<=c)++words;
				else words=1;
			}
			
			//Display the result
			System.out.println(words);			
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
