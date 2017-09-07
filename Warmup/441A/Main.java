//441A : VALERA AND ANTIQUE ITEMS


/*
 *	Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Set Interface(LinkedHashSet is recommended)
 * 	- Use of Iterator Interface
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			
			//Take the necessary inputs
			int sellers=in.nextInt(), 
				money=in.nextInt();
			
			//Declare the necessary entities for output
			LinkedHashSet<Integer> index=new LinkedHashSet<Integer>();
			int i=1;
			
			//Evaluate the solution
			while(sellers-- > 0){
				int counter=in.nextInt();
				while(counter-- > 0){
					int value=in.nextInt();
					if(money>value)index.add(i);
				}
				++i;
			}
			
			//Display the result
			Iterator<Integer> it=index.iterator();
			out.println(index.size());
			while(it.hasNext())out.print(it.next()+" ");
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
