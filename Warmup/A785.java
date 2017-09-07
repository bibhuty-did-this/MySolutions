package completed;
//785A : ANTON AND POLYHEDRON
/*
 * Prerequisite:
 * 	- Implementation
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A785 {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			//Put the data
			Map<String, Integer> polygon=new HashMap<String, Integer>();
	        polygon.put("Tetrahedron", 4);
	        polygon.put("Cube", 6);
	        polygon.put("Octahedron", 8);
	        polygon.put("Dodecahedron", 12);
	        polygon.put("Icosahedron", 20);
	        
	        //Take the input
	        int n=in.nextInt();
	        long total=0;
	        
	        //Evaluate the result
	        while(n-->0)total+=polygon.get(in.next());
	        
	        //Print the result
	        out.println(total);
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
        
        public long nextLong() {
            return Long.parseLong(next());
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
