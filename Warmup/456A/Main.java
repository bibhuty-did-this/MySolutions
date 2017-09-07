//456A : LAPTOPS

/*
 * Solution: http://codeforces.com/contest/456/submission/23789581
 */

/*
 * Prerequisite:
 * 	- Sorting
 *  - Comparable Interface
 *  - Logical Reasoning
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Your code goes here
public class Main {	
	
	static class ProblemSolver{
		
		/*
		 * User defined data structure essential for
		 * the problem. It is highly recommended to use
		 * this data structure as a standard data structrue
		 * as in many cases of competetive programming similar
		 * type of problems are encountered.
		 * 
		 *  Comparable interface is implemented to provide ease
		 *  on selective sorting on the basis of the cost 
		 */
		class Pair implements Comparable<Pair>{
			int price;
			int quality;
			
			public Pair(int price,int quality) {
				this.price=price;
				this.quality=quality;
			}			

			public int compareTo(Pair o) {
				return Integer.compare(o.price,this.price);
			}
			
		}
		
		public void solveTheProblem(InputReader in,PrintWriter out){
			
			//Declare & scan the necessary inputs
			int n=in.nextInt();
			ArrayList<Pair> pairs=new ArrayList<Pair>();
			while(n-->0){
				int price=in.nextInt();
				int quality=in.nextInt();
				pairs.add(new Pair(price, quality));
			}
			
			//Sort the inputs on the basis of the cost 
			//(from higher to lower in this case)
			Collections.sort(pairs);			
			/*
			 * Debugging code:
			 * 	for(Pair p:pairs)System.out.println(p.price+" "p.quality);
			 */
			
			//Estimation & display of solution
			/*
			 * In the sorted pair we need to find a pair such that
			 * there exist a pair such that quality of the former
			 * is less than the quality of the later to prove that
			 * there exist a pair according to Alex's assumption
			 */
			for(int i=1;i<pairs.size();++i){
				if(pairs.get(i-1).quality<pairs.get(i).quality){
					System.out.println("Happy Alex");
					return;
				}
			}
			System.out.println("Poor Alex");
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
