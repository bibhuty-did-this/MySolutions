//489C : GIVEN LENGTH AND SUM OF DIGITS...

/*
 * Solution: http://codeforces.com/contest/489/submission/23720128
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
			//Declare the necessary variables and take all the inputs
			int m=in.nextInt();
			int s=in.nextInt();
			int[] max;
			int[] min;
						
			//Evaluation of solution and display of the result
			/*
			 * The most basic and the trickiest base case.
			 * In the question it is mentioned `no leading zeroes`,
			 * this is the outcome of that expression.			 * 
			 */
			if(m==1 && s==0)System.out.println("0 0");
			/*
			 * It involves simple mathematics as shown in the 
			 * if condition but it is to be noted that one of
			 * its cases is an exception which is covered above
			 */
			else if(s>(9*m) || s<1)System.out.println("-1 -1");
			/*
			 * This is the real evaluation stage. Here we need
			 * to know that to maximize a number it should have the 
			 * maximum value at the beginning and vice versa. 
			 * The question is approached in an exact manner but
			 * taking care of an expression in which we need to take
			 * care that the condition of m numbers must be fulfilled.
			 * Ex: m=3, s=17
			 * 	   max=980 but min can't be 089 instead 
			 * 	   min=179 or (1(8-1)9)
			 */
			else{
				max=new int[m];
				min=new int[m];
				for(int i=0;i<m;++i){
					max[i]=0;
					min[i]=0;
				}
				int i=0;				
				while(s>0){
					if(s>9){
						max[i]=9;
						min[m-1-i]=9;
						s-=9;
					}else{
						max[i]=s;
						min[m-1-i]=s-1;
						min[0]+=1;
						break;
					}
					++i;
				}
				for(int j=0;j<m;++j)System.out.print(min[j]);
				System.out.print(" ");
				for(int j=0;j<m;++j)System.out.print(max[j]);
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
