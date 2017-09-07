//474B : WORMS
/*
 * Solution: http://codeforces.com/contest/474/submission/23722973 
 */
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
			/*
			 * This question need an approach where we need to
			 * solve it in a systematic manner along with the inputs.
			 * We need to construct a lookup table in order to solve 
			 * this issue. As we know that every worm can be mapped with
			 * one of the pile we should do that at the beginning only.
			 * Then it is a matter on O(1) search. This algorithm decreases
			 * the time complexity like anything. It also denotes that
			 * sometimes we need to trade space to make a program time
			 * efficient.
			 */
			int piles=in.nextInt();
			int[] look=new int[1000005];
			int j=1;
			for(int i=1;i<=piles;++i){
				int up=in.nextInt();
				while(up>0){
					look[j]=i;
					--up;
					++j;
				}
			}
			int fav=in.nextInt();
			int[] ans=new int[fav];
			for(int i=0;i<fav;++i){
				int idx=in.nextInt();
				ans[i]=look[idx];
			}
			for(int i=0;i<fav;++i)System.out.println(ans[i]);
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
