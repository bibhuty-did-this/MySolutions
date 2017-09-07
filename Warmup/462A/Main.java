//462A : APPLEMAN AND EASY TASK
/*
 * Prerequisite:
 * 	- Implementation
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
			
			//Take the necessary inputs
			int n=in.nextInt();
			String[] board=new String[n];
			for(int i=0;i<n;++i)board[i]=in.next();
			
			//Evaluation and display of the result
			for(int i=0;i<n;++i){
				for(int j=0;j<n;++j){
					int count=0;
					if(isFeasible(i-1, n)){
						if(board[i-1].charAt(j)=='o')++count;
					}
					if(isFeasible(i+1, n)){
						if(board[i+1].charAt(j)=='o')++count;
					}
					if(isFeasible(j-1, n)){
						if(board[i].charAt(j-1)=='o')++count;
					}
					if(isFeasible(j+1, n)){
						if(board[i].charAt(j+1)=='o')++count;
					}
					if(count%2!=0){
						out.print("NO");
						return;
					}
				}
			}
			out.print("YES");
		}	
		
		boolean isFeasible(int i,int n){
			return (i>=0 && i<=n-1)?true:false;
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
