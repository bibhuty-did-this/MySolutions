//550A : TWO SUBSTRINGS


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- String manipulation
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			//String input
			String s=in.next();
			
			//To store the next index of AB or BA
			int ab=-1,ba=-1;
			
			//To check if AB is found after BA & vice-versa
			boolean AB=false,BA = false;
			
			//Calculation to find the index of AB and BA if exists
			for(int i=1;i<s.length() && (ab==-1 || ba==-1);++i){
				if(ab==-1 && s.charAt(i-1)=='A' && s.charAt(i)=='B')ab=i+1;
				if(ba==-1 && s.charAt(i-1)=='B' && s.charAt(i)=='A')ba=i+1;
			}
			
			//Calculation to find if AB is found after BA & vice-versa
			if(ab!=-1)for(int i=ab;i<s.length()-1 && !BA;++i)if(s.charAt(i)=='B' && s.charAt(i+1)=='A')BA=true;
			if(ba!=-1)for(int i=ba;i<s.length()-1 && !AB;++i)if(s.charAt(i)=='A' && s.charAt(i+1)=='B')AB=true;
			
			//Display of the result			
			if(AB || BA)out.print("YES");
			else out.print("NO");
			
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
