//733A : GRASSHOPPER AND THE STRING

/*
 * Solution: http://codeforces.com/contest/733/submission/23771222
 */

/*
 * Prerequisite:
 * 	- String processing
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
			
			//Take the necessary inputs and variables
			String s=in.next();
			
			//Evaluation of the result
			/*
			 * Here we need to take care of simply one thing
			 * i.e. the indexing. Say the length of the string
			 * is n then as we know the indexing starts from 0
			 * and ends with n-1 but here we have 2 more indices
			 * 		1. start(-1) 
			 * 		2. end(n)
			 * 
			 * Rest is all about finding the maximum gap b/w
			 * 2 alphabets considering both the start and end
			 * indices.
			 */
			int max=0;
			int start=-1;/* start index as -1 */
			for(int curr=0;curr<s.length();++curr){
				if(s.charAt(curr)=='A'||s.charAt(curr)=='E'||s.charAt(curr)=='I'||s.charAt(curr)=='O'||s.charAt(curr)=='U'||s.charAt(curr)=='Y'){
					max=Math.max(max, curr-start);
					start=curr;
				}
			}
			/* considering the case of end index */
			max=Math.max(max, s.length()-start);
			
			//Displaying of the result
			System.out.println(max);
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
