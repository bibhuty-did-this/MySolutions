//330A : CAKEMINATOR


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Simple matrix concept
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			//Take the necessary inputs
			int r=in.nextInt(),c=in.nextInt();
			
			//To keep track of number of rows and column containing strawberries
			HashSet<Integer> rows,cols;
			rows=new HashSet<Integer>();
			cols=new HashSet<Integer>();
			
			/*
			 * Calculation to keep track of the nubmer of rows 
			 * and columns containing strawberries
			 */
			for(int i=0;i<r;++i){
				String s=in.next();
				for(int j=0;j<c;++j){
					if(s.charAt(j)=='S'){
						rows.add(i);
						cols.add(j);
					}
				}
			}
			
			/*
			 * Normal mathematics for calculating the number of 
			 * rows and column to be traversed
			 */
			out.print(((c-cols.size())*r)+((r-rows.size())*c)-((r-rows.size())*(c-cols.size())));
			
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
