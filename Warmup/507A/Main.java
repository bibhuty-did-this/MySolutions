//507A : AMR AND MUSIC

/*
 * Solution: http://ideone.com/47X4qc
 */

/*
 * Prerequisite:
 * 	- Comparable Interface
 * 	- Sorting
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
		 * Most necessary data structure storing them in
		 * pairs of days and indices and also having the
		 * capability of sorting them in terms of days
		 */
		class Pair implements Comparable<Pair>{
			int days;
			int index;
			public Pair(int days,int index) {
				this.days=days;
				this.index=index;
			}
			public int compareTo(Pair o) {
				return Integer.compare(this.days, o.days);
			}	
			
		}
		public void solveTheProblem(InputReader in,PrintWriter out){
			//Take necessary inputs
			int n=in.nextInt();
			int total=in.nextInt();
			ArrayList<Pair> pairs=new ArrayList<>();
			for(int index=1;index<=n;++index){
				int days=in.nextInt();
				pairs.add(new Pair(days, index));
			}
			
			//Sort the necessary inputs in terms of days
			Collections.sort(pairs);
			
			//Save the number of indices in another list and
			//count the number of days simultaneously
			ArrayList<Integer> instrument=new ArrayList<>();
			int counter=0;
			for(Pair p:pairs){
				if(p.days<=total){
					instrument.add(p.index);
					total-=p.days;
					++counter;
				}else break;				
			}
			
			//Display the result
			out.println(counter);
			for(int i:instrument)out.print(i+" ");
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
