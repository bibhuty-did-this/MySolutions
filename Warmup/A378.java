package completed;
//378A : PLAYING WITH DICE
/*
 * Prerequisite:
 * 	- Math
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A378 {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			
			//Input
			int a=in.nextInt(),
				b=in.nextInt();
			
			//Evaluation
			int aw=0,bw=0,dw=0;
			for(int i=1;i<=6;++i){
				if(Math.abs(a-i)<Math.abs(b-i))++aw;
				else if(Math.abs(a-i)>Math.abs(b-i))++bw;
				else ++dw;
			}
			
			//Print the solution
			out.print(aw+" "+dw+" "+bw);
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
