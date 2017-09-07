//611A : NEW YEAR AND DAYS	

/* Solutions:
 * 		- Ideone: http://ideone.com/EgS6xl
 * 		- Codeforces: http://codeforces.com/contest/611/submission/23802979
 * 
 */

/*
 * Prerequisite:
 * 	- Leap year concept
 *  - Logical reasoning
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
			//Take the necessary inputs
			int n=in.nextInt();
			String of=in.next();
			String week_or_month=in.next();
			
			//Evaluation and display of outuput
			/*
			 * Algorithm:
			 * 	- Calcuate manually how many Sundays, Mondays etc
			 *    the year would have.(It'll have 53 Fridays and 
			 *    Saturdays & 52 other days)
			 *  - Calculate how many indices of dates a month can 
			 *    accomodate.(31 can be accomodated only by 7 
			 *    months, 30 by 11 and others by all 12 months) 
			 */
			if(week_or_month.length()>4){
				if(n==31)out.println("7");
				else if(n==30)out.println("11");
				else out.println("12");
			}else{
				if(n==6 || n==5)out.println("53");
				else out.println("52");
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
