
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//489B
public class Main {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
		Problem solver = new Problem();
		solver.solve(in,out);		
		out.close();		
	}
	
	static class Problem{
		public void solve(InputReader in,PrintWriter out){			
			int n=in.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;++i)a[i]=in.nextInt();		
			Arrays.parallelSort(a);		
			
			int m=in.nextInt();
			int[] b = new int[m];
			for(int i=0;i<m;++i)b[i]=in.nextInt();
			Arrays.parallelSort(b);	
						
			int i=0,j=0,pair=0;
			
			while(i<n && j<m){
				if(Math.abs(a[i]-b[j])<=1){
					++pair;
					++i;
					++j;
				}else if(a[i]>b[j])++j;
				else ++i;
			}
			out.println(pair);				
		}
	}
	
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

}
