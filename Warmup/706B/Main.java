//706B: Interesting Drink


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Mathematics
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
			
			//Take the necessary inputs
			int n=in.nextInt();
			int[] shop=new int[n];
			for(int i=0;i<n;++i)shop[i]=in.nextInt();
			int q=in.nextInt();
			int[] bottle=new int[q];
			for(int i=0;i<q;++i)bottle[i]=in.nextInt();
			
			//Evaluate the result
			Arrays.sort(shop);
			int[] answer=new int[100001];
			for(int i=0;i<n-1;++i){
				for(int j=shop[i];j<=shop[i+1];++j)answer[j]=i+1;
			}
			for(int j=shop[n-1];j<answer.length;++j)answer[j]=n;
			
			//Display the result
			for(int i=0;i<q;++i){
				if(bottle[i]>=100000)out.println(n);
				else out.println(answer[bottle[i]]);
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
