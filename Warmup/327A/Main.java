//327A : FLIPPING GAME

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
			//Take the necessary inputs and 
			//declare all the necessary variables
			int n=in.nextInt();
			/*
			 * Setting the value of M=-1 ensures the base case
			 * i.e the case of at least one inversion. Also
			 * setting the value of m=-1 ensures the same in
			 * the for loop below.
			 */
			int one=0,M=-1;
			int[] num=new int[n];
			int[] dp=new int[n];
			for(int i=0;i<n;++i){
				dp[i]=0;
				num[i]=in.nextInt();
				one+=num[i];
			}			
			for(int i=0;i<n;++i){
				int m=-1;
				if(num[i]==0){
					m=0;
					while(i<n){
						if(num[i]==0)++m;
						else if(num[i]==1 && m==1)break;
						else --m;
						++i;
						M=Math.max(M, m);
					}					
				}
			}
			System.out.println(one+M);
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
