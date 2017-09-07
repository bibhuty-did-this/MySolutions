//711 A: BUS TO UDAYLAND

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
			
			//Take the necessary inputs
			int n=in.nextInt();//no of seats
			int index=-1;//to note the row of the seat in which they can sit
			String[] seats=new String[n];
			for(int i=0;i<n;++i)seats[i]=in.next();
			
			
			//Brute force search for the row and 
			//storing the row number of the seat in index
			for(int i=0;i<n;++i){
				if(seats[i].indexOf("OO")!=-1){
					index=i;
					break;
				}
			}
			
			
			if(index==-1)System.out.println("NO");
			else{
				System.out.println("YES");
				//Print the result
				for(int i=0;i<n;++i){
					if(i==index)System.out.println(seats[i].replaceFirst("OO","++"));
					else System.out.println(seats[i]);
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
