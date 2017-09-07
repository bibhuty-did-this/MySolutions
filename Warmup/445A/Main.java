import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//445A
public class Main {	
	
	static class ProblemSolver{
		public void solveTheProblem(InputReader in,PrintWriter out){
			int n = in.nextInt();
			int m = in.nextInt();
			String[] chessBoard = new String[n];
			boolean flip = true;
			for(int i=0;i<n;++i)chessBoard[i] = in.next();
			String black ="",white="";
			for(int i=0;i<m;++i){
				if(flip){
					black+="B";
					white+="W";
				}else{
					black+="W";
					white+="B";
				}
				if(flip)flip=false;
				else flip=true;
			}
			int idx=0;
			while(idx<n){
				if(idx%2==0){
					for(int i=0;i<m;++i){
						if(chessBoard[idx].charAt(i)=='-')out.print(chessBoard[idx].charAt(i));
						else out.print(white.charAt(i));
					}
				}else{
					for(int i=0;i<m;++i){
						if(chessBoard[idx].charAt(i)=='-')out.print(chessBoard[idx].charAt(i));
						else out.print(black.charAt(i));
					}
				}
				out.println();
				++idx;
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
