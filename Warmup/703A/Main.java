//703A : MISHKA AND GAME

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
			
			//Declare all the necessary variables
			int n=in.nextInt();//no of turns
			int m=0,c=0;//m to be incremented in Mishka wins and c if Chris wins
			
			//Calculation of number of wins
			/*
			 * Note:-
			 * 	- Declaring a variable inside the for loop is memory efficient 
			 *    so it is recommended use this style of declaration whereever possible
			 */
			for(int i=1;i<=n;++i){
				int M,C;
				M=in.nextInt();
				C=in.nextInt();
				if(M>C)++m;
				else if(M<C)++c;
				else continue;
			}
			
			//Display the result
			if(m>c)System.out.println("Mishka");
			else if(c>m)System.out.println("Chris");
			else System.out.println("Friendship is magic!^^");
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
