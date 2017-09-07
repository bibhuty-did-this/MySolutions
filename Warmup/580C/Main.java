import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

//580C
public class Main {	
	
	static class ProblemSolver{
		int n,m;
		ArrayList<ArrayList<Integer>> Graph;
		int[] cat;
		public void solveTheProblem(InputReader in,PrintWriter out){
			n = in.nextInt();
			m = in.nextInt();
			Graph = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<n+1;++i)Graph.add(new ArrayList<Integer>());
			cat = new int[n+1];
			for(int i=1;i<=n;++i)cat[i]=in.nextInt();
			for(int i=1;i<n;++i){
				int x,y;
				x = in.nextInt();
				y = in.nextInt();
				Graph.get(x).add(y);
				Graph.get(y).add(x);
			}
			out.println(DFS());
		}
		public int DFS(){
			int paths=0;
			boolean[] isVisited = new boolean[n+1];
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(1);
			while(!stack.isEmpty()){
				Stack<Integer> auxStack = new Stack<Integer>();
				int V=stack.pop();
				isVisited[V]=true;
				for(int v:Graph.get(V)){
					if(!isVisited[v]){
						auxStack.push(v);
						if(cat[v]==1)cat[v]+=cat[V];
					}
				}
				if(auxStack.isEmpty())++paths;
				while(!auxStack.isEmpty()){
					if(cat[auxStack.peek()]<=m)stack.push(auxStack.pop());
					else auxStack.pop();
				}
			}
			return paths;
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
