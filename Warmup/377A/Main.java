import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//377A
public class Main {	
	
	static class ProblemSolver{
		int n,m,k,s=0,rows,col,counter;	
		char[][] maze;
		boolean[][] isVisited;
		public void solveTheProblem(InputReader in,PrintWriter out){			
			n=in.nextInt();
			m=in.nextInt();
			k=in.nextInt();
			maze=new char[n][m];
			for(int i=0;i<n;++i){
				maze[i]=in.next().trim().toCharArray();
				for(int j=0;j<m;++j)if(maze[i][j]=='.')++s;
			}
			isVisited=new boolean[n][m];
			outer:
			for(int i=0;i<n;++i){
				for(int j=0;j<m;++j){
					if(maze[i][j]=='.'){
						rows=i;
						col=j;
						break outer;
					}
				}
			}
			BFS();
			for(int i=0;i<n && counter>0;++i){
				for(int j=0;j<m && counter>0;++j){
					if(maze[i][j]=='.' && !isVisited[i][j])out.print("X");
					else out.print(maze[i][j]);
				}
				out.println();
			}
			
		}
		void BFS(){
			Queue<Integer> r=new LinkedList<Integer>();
			Queue<Integer> c=new LinkedList<Integer>();
			r.add(rows);
			c.add(col);
			isVisited[rows][col]=true;	
			counter=1;
			while(counter!=(s-k)){
				rows=r.poll();
				col=c.poll();			
				if(rows!=0 && maze[rows-1][col]=='.' && !isVisited[rows-1][col]){
					r.add(rows-1);
					c.add(col);
					++counter;
					isVisited[rows-1][col]=true;
					if(counter==(s-k))break;
				}
				if(rows!=(n-1) && maze[rows+1][col]=='.' && !isVisited[rows+1][col]){
					r.add(rows+1);
					c.add(col);
					++counter;
					isVisited[rows+1][col]=true;
					if(counter==(s-k))break;
				}
				if(col!=0 && maze[rows][col-1]=='.' && !isVisited[rows][col-1]){
					r.add(rows);
					c.add(col-1);
					++counter;
					isVisited[rows][col-1]=true;
					if(counter==(s-k))break;
				}
				if(col!=(m-1) && maze[rows][col+1]=='.' && !isVisited[rows][col+1]){
					r.add(rows);
					c.add(col+1);					
					++counter;
					isVisited[rows][col+1]=true;
					if(counter==(s-k))break;
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
