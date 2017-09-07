//451B : SORT THE ARRAY


/*
 * Github Link of the Solution
 */


/*
 * Prerequisite:
 * 	- Arrays and Sorting
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
			/*
			 * It is possible to find such an array where flipping 
			 * a segment gives a sorted array if and only if there is
			 * only one decreasing segment and rest of the segment are
			 * increasing if any. 
			 * 
			 * Note:-
			 * 	~ Take care of the base cases properly.
			 */
		
			//Take the necessary inputs
			int n=in.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;++i)arr[i]=in.nextInt();
			
			//Evaluation and display of result
			/*
			 * - Here `flip` variabl is used to take care of
			 * 	 the situation when the segment of the array
			 *   goes in decreasing order
			 * 
			 * - Start and ends stores the start and the end 
			 *   index of the segment
			 *   
			 * - The for loop finds the segment and updates 
			 *   start and end variable
			 *  
			 * - The while loop takes care of the situation where
			 *   no such decreasing segment is found
			 *   
			 * - The other if and else statements are used to
			 *   verify if the start and end variables are upto
			 *   the mark. Ex: 1 2 4 5 (8 7 6 4) 10, here although
			 *   the segment is possible but it is not possible to 
			 *   sort this array after reversing the segments
			 *   	
			 */
			boolean flip=false;
			int start=0;
			int end=0;
			int i;
			for(i=1;i<n;++i){
				if(arr[i]<arr[i-1]){
					if(!flip){
						start=i-1;
						flip=true;
					}
					if(i==n-1)end=n-1;
				}else if((arr[i]>arr[i-1] || i==(n-1)) && flip){
					end=i-1;
					break;
				}
			}
			while(i<n){
				if(arr[i-1]>arr[i]){
					out.print("no");
					return;
				}
				++i;
			}
			if(start!=0 && end!=n-1){
				if(arr[start-1]<arr[end] && arr[end+1]>arr[start]){
					out.println("yes");
					out.println((start+1) +" "+ (end+1));
				}else out.println("no");
			}else if(start==0 && end!=n-1){
				if(arr[end+1]>arr[start]){
					out.println("yes");
					out.println((start+1) +" "+ (end+1));
				}else out.println("no");
			}else if(start!=0 && end==n-1){
				if(arr[start-1]<arr[end]){
					out.println("yes");
					out.println((start+1) +" "+ (end+1));
				}else out.println("no");
			}else if(start==end && n!=1){
				out.println("no");
			}else{
				out.println("yes");
				out.println((start+1) +" "+ (end+1));
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
