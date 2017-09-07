//719A : VITYA IN THE COUTNRYSIDE

/*

 * Solution: http://codeforces.com/contest/719/submission/23788380
 */

/*
 * Prerequisite:
 * 	- Logical Reasoning
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
			 * Declare the variables
			 * Take the necessary inputs 
			 * Compute the result along with the other steps 
			 */
			int n=in.nextInt();
			/*
			 * If the number of inputs is 1 then the result
			 * is determinable if and only if the input is 
			 * 15 or 0 as after the 15th day the moon has to 
			 * reduce its size and after the 0th day it has to
			 * increase its size. And for others it is not possible
			 * Ex: if it is the case of 8th day then it could be 
			 *     successor of either 7 or 9.
			 */
			if(n==1){
				int temp=in.nextInt();
				if(temp==0)System.out.println("UP");
				else if(temp==15)System.out.println("DOWN");
				else System.out.println("-1");
				return;
			}
			/*
			 * In the loop we simply need to take care of one
			 * condition that is the previously scanned variable
			 * must be either one greater or one less than the
			 * current scanned variable.
			 */
			int current,previous,_previous;
			current=in.nextInt();
			previous=current;
			_previous=previous;
			--n;
			while(n-->0){
				current=in.nextInt();
				if(current==(_previous-1)||current==(_previous+1)){
					previous=_previous;
					_previous=current;					
				}else{
					System.out.println("-1");
					return;
				}
			}
			/*
			 * After the loop we need to take care of the exception 
			 * that if the current value is 15 then the size will
			 * decrease and if it 0 then the size will increase.
			 * 
			 * And for the other cases it is obvious that if the 
			 * previous is less than the current then the moon is 
			 * in increasing stage and vice versa.
			 * Ex: previous = 13 and current = 	14 then the next
			 *     would be 15.
			 */
			if(current==15)System.out.println("DOWN");
			else if(current==0)System.out.println("UP");
			else if(previous<current)System.out.println("UP");
			else if(previous>current)System.out.println("DOWN");
			
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
