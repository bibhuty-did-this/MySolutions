//118B : PRESENT FROM LENA

/*
 * Solution: http://codeforces.com/contest/118/submission/23792402
 */

/*
 * Prerequisite:
 * 	- Simple concepts of string processing
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
			//Take the input
			int n=in.nextInt();
			String[] s=new String[n+1];
			
			/*
			 * This problem is intended to solve by using simple
			 * string manipulation. But at first we need to store
			 * strings from 0 to 0123...n in a string array of 
			 * length n+1. Here s[i] represents the string 012..i
			 */
			s[0]=Integer.toString(0);			
			for(int i=1;i<=n;++i){
				s[i]=s[i-1];
				s[i]+=Integer.toString(i);	
			}
			
			/*
			 * Algorithm :
			 * 	- Print the number of gaps first
			 *  - Print the first half of the line
			 *  - Print the second half by printing the 
			 *    previous line's first half string in
			 *    reverse order taking care of the 
			 *    condition that 0 is not printed with
			 *    a gap or else it'll show the error
			 */
			
			/*
			 * Upper half of pyramid
			 */
			for(int i=0;i<=n;++i){
				//gaps
				for(int j=0;j<n-i;++j)out.print("  ");
				
				//first half of the line
				if(i!=0){
					for(int j=0;j<s[i].length();++j){
						out.print(s[i].charAt(j)+" ");
					}
				}else out.print("0");
				
				//second half of the line by printing
				//first half of previous line in reverse order
				if(i!=0){
					for(int j=s[i-1].length()-1;j>0;--j){
						out.print(s[i-1].charAt(j)+" ");
					}
					out.print("0");
				}
				out.println();
			}
			
			/*
			 * Lower half of the pyramid
			 */
			for(int i=n-1;i>=0;--i){
				//gaps
				for(int j=0;j<n-i;++j)out.print("  ");
				
				//first half of the line
				if(i!=0){
					for(int j=0;j<s[i].length();++j){
						out.print(s[i].charAt(j)+" ");
					}
				}else out.println("0");
				
				//second half of the line by printing
				//first half of previous line in reverse order
				if(i!=0){
					for(int j=s[i-1].length()-1;j>0;--j){
						out.print(s[i-1].charAt(j)+" ");
					}
					out.print("0");
				}
				out.println();
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
