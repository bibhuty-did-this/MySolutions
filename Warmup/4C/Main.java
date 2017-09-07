//4C : REGISTRATION SYSTEM

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
//Your code goes here
public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			
			//Declare the necessary variables
			//Take required inputs
			HashMap<String, Integer> names=new HashMap<String,Integer>();
			int n=in.nextInt();
			String[] users=new String[n];
			for(int i=0;i<n;++i)users[i]=in.next();
			
			
			/*
			 * Evaluation of the expression:
			 * 	- Insert the value into the map 
			 * 	  if it doesn't exist and print "OK"
			 *  - If it exists then simply replace
			 *    it with the higher value of key
			 *    and append the higher value at the 
			 *    end of the duplicate key 
			 */
			for(int i=0;i<n;++i){
				if(!names.containsKey(users[i])){
					names.put(users[i], 0);
					System.out.println("OK");
				}else{
					int key=names.get(users[i]);
					names.replace(users[i], key+1);
					System.out.print(users[i]);
					System.out.println(key+1);
				}
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
