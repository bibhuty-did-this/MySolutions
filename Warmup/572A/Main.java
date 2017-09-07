//572A : ARRAYS


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Sorting
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			/*
			 * Algorithm:
			 * 	- Sort both the arrays
			 *  - If kth element of first array is strictly less 
			 *    than the mth element of second array from the
			 *    end then there is a possible answer
			 */
			
			//Take the necessary inputs
			int na=in.nextInt(),
			    nb=in.nextInt(),
			    k=in.nextInt(),
			    m=in.nextInt();
			int[] A=new int[na];
			int[] B=new int[nb];
			for(int i=0;i<na;++i)A[i]=in.nextInt();
			for(int i=0;i<nb;++i)B[i]=in.nextInt();
			
			//Evaluate  and display the result
			Arrays.sort(A);
			Arrays.sort(B);
			if(A[k-1]<B[nb-m])out.print("YES");
			else out.print("NO");
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
