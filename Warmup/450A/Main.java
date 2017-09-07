//450A : JZZHU AND CHILDREN


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 *  - Simple mathematics
 *  - Round Robin Algorithm(optional)
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			
			//Take the necessary inputs
			int n=in.nextInt();
			int m=in.nextInt();
			int[] children=new int[n];
			Queue<Integer> queue=new LinkedList<Integer>();			
			for(int i=0;i<n;++i){
				children[i]=in.nextInt();
				queue.add(i);
			}
			
			//Use the queue to keep track of the students availaible
			//till you find the last student
			while(queue.size()!=1){
				if(children[queue.peek()]<=m)queue.poll();
				else{
					children[queue.peek()]-=m;
					queue.add(queue.poll());
				}
			}
			
			
			//Display the result
			out.print(queue.poll()+1);
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
