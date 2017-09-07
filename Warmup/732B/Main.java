//732B : CORMEN THE BEST FRIEND OF A MAN


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Greedy Algorithm
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
			
			//Taking necessary inputs and evaluating the result
			int n=in.nextInt();
			int k=in.nextInt();
			int[] walks=new int[n];
			
			/*
			 * Hint:
			 * 	- Ensure that the sum of the present and the previous 
			 * 	  input doesn't exceed the total number of walks
			 */
			int total=0;
			walks[0]=in.nextInt();
			for(int i=1;i<n;++i){
				walks[i]=in.nextInt();
				if(walks[i]+walks[i-1]>=k)continue;
				else{
					int extra=(k-walks[i-1]-walks[i]);
					total+=extra;
					walks[i]+=extra;
			 	}
			}
			
			//Display the result
			out.println(total);			 
			for(int i=0;i<n;++i)out.print(walks[i]+" ");
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
