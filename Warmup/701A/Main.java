//701A : CARDS

/*
 * Solution: http://codeforces.com/contest/701/submission/23759403
 */

/*
 * Prerequisite:
 * 	- Simple OOPs concept
 * 	- Use of Comparator and Comparable Interfaces
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//Your code goes here
public class Main {	
	
	static class ProblemSolver{
		/*
		 * This class is highly requires as we want to sort 
		 * them in terms of their values. I would recommend 
		 * to read carefully this class in order to unders-
		 * tand a type of problem which is generally encou-
		 * ntered in competetive programming.
		 */
		class Pair implements Comparator<Pair>,Comparable<Pair>{
			int first;
			int second;
			public Pair(int first,int second) {
				this.first=first;
				this.second=second;
			}
			public int compareTo(Pair o) {			
				return Integer.compare(this.second, o.second);
			}
			public int compare(Pair o1, Pair o2) {
				if(o1.second>=o2.second)return 1;
				else return 0;
			}
		}
		
		public void solveTheProblem(InputReader in,PrintWriter out){
			
			//Declare the necessary variables and take the inputs
			int n=in.nextInt();
			ArrayList<Pair> pair=new ArrayList<Pair>();
			for(int i=1;i<=n;++i){
				int value=in.nextInt();
				pair.add(new Pair(i, value));				
			}
			
			//Do the necessary calculations and
			//refer the Pair class for details
			Collections.sort(pair);
			int i=0;
			int[] sol=new int[n];
			for(Pair p:pair){
				sol[i]=p.first;
				++i;
			}
			
			//Display the results
			for(i=0;i<n/2;++i){
				System.out.println(sol[i]+" "+sol[n-1-i]);
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
