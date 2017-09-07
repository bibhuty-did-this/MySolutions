package completed;
//368B : SEREJA AND SUFFIXES
/*
 * Prerequisite:
 * 	- Dynamic Programming
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B368 {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			/*
			 * Algorithm:
			 * 	~ Keep track of number of instances of all the numbers
			 *    and the number of distinct numbers also
			 * 	~ In each point of the array keep track of number of 
			 *    instances vanishing completely. If any of the instance
			 *    completely vanishes then decrease the size of the distinct
			 *    numbers by one thereby storing them in the answer array 
			 *    simultaneously
			 *  ~ The rest answer is only about printing the answer from the
			 *    lookup table according to the value of l
			 */
			
			//Input, processing and output
			int[] table=new int[100001];//memorization table
			int counter=0;//to keep track of distinct values
			int n=in.nextInt(),m=in.nextInt();
			int[] a=new int[n];
			int[] ans=new int[n];//main memorization table of dp
			for(int i=0;i<n;++i){
				a[i]=in.nextInt();
				if(table[a[i]]==0)++counter;
				++table[a[i]];				
			}
			for(int i=0;i<n;++i){
				ans[i]=counter;
				--table[a[i]];
				if(table[a[i]]==0)--counter;
			}
			for(int i=0;i<m;++i){
				int l=in.nextInt();
				out.println(ans[l-1]);
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
