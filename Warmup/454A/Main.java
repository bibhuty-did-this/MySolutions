//454A : LITTLE PONY AND CRYSTAL MINE


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Simple string manipulation
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
			//Take the input
			int n=in.nextInt();
			
			//Declare the necessary variables
			char[][] crystal=new char[n][n];
			int increment=0;
			String s="";
			for(int i=0;i<n;++i){
				s=s.concat("*");
			}
			
			//Evaluate the given problem
			/*
			 * Algorithm:
			 * 	- Fill all the arrays with * first
			 * 	- Then symmetrically fill up the arrays
			 */
			for(int i=0;i<=n/2;++i,++increment){
				crystal[i]=s.toCharArray();
				crystal[n-1-i]=s.toCharArray();
				for(int j=0;j<=increment;++j){
					crystal[i][n/2-j]='D';
					crystal[i][n/2+j]='D';
					crystal[n-1-i][n/2-j]='D';
					crystal[n-1-i][n/2+j]='D';
				}
			}
			
			//Display the result
			for(int i=0;i<n;++i){
				for(int j=0;j<n;++j)out.print(crystal[i][j]);
				out.println();
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
