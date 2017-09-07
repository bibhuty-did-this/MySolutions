//189A : CUT RIBBON

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
			int n=in.nextInt();
			int a=in.nextInt();
			int b=in.nextInt();
			int c=in.nextInt();
			int[] dp=new int[4001];
			
			//Fill all the default entry of the dp as -1 as done in most of the cases
			for(int i=0;i<=n;++i)dp[i]=-1;
			
			//Initialize the given data in the dp
			dp[a]=1;
			dp[b]=1;
			dp[c]=1;
			
			//Evaluate and take the optimal of all
			for(int i=Math.min(a, Math.min(b, c));i<=n;++i){
				if(i-a>=0 && dp[i-a]!=-1)dp[i]=Math.max(dp[i-a]+1,dp[i]);
				if(i-b>=0 && dp[i-b]!=-1)dp[i]=Math.max(dp[i-b]+1,dp[i]);
				if(i-c>=0 && dp[i-c]!=-1)dp[i]=Math.max(dp[i-c]+1,dp[i]);
			}
			
			//Print the result
			System.out.println(dp[n]);
			
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
