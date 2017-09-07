package completed;
//313B : ILYA AND QUERIES
/*
 * Prerequisite:
 * 	- Dynamic Programming
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class B313{
    //User defined class where the main code goes
    static class ProblemSolver{
      public void solveTheProblem(InputReader in,PrintWriter out) throws IOException{
    	//Take the necessary inputs
        String s=in.nextString();
        int length=s.length();
        int m=in.nextInt();
        
        //Declare the necessary variables
        int[] similar=new int[length];
        int dot=0,hash=0;
        
        /*
         * Algorithm:
         * 	- If adjacent values are similar 
         * 		+ if it is a dot increment dot
         * 		+ if it is a hash increment hash
         * 	- Add both of them to store the total similarity till then 
         */
        for(int i=1;i<length;++i){
        	if(s.charAt(i)==s.charAt(i-1)){
        		if(s.charAt(i)=='.')++dot;
        		else ++hash;
        	}
        	similar[i]=dot+hash;
        }
        
        //Print the result
        while(m-->0)out.println(-similar[in.nextInt()-1]+similar[in.nextInt()-1]);
        
      }					
    }
		
    //User defined class to read the input faster 
    static class InputReader{
      final private int BUFFER_SIZE = 1 << 16;//To store a large buffer size
      private DataInputStream din;//This is used for fast IO in Java
      private byte[] buffer;//buffer array to store the elements in the buffer and byte is used as it takes less memory
      private int bufferPointer;//to keep track of the current index of the buffer
      private int bytesRead;//to keep track of the net size of the current buffer
 
      //Constructor for initialization
      public InputReader(){
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
      }
 				
      //Method to read character by character
      private byte read() throws IOException{
        if(bufferPointer == bytesRead)fillBuffer();//if the buffer is fully read then take care of the buffer
        return buffer[bufferPointer++];//return the current buffer element
      }
				
      //Method to keep check of the buffer
      private void fillBuffer() throws IOException{
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);//to keep track of if the buffer has elements or not	
        if(bytesRead == -1)buffer[0] = -1;//if the buffer is empty then return -1(or anything as we wish but we have to change the above program)
      }
				
      //Method to read an entire line
      public String readLine() throws IOException{
    	int lineLengthMax=64; //maximum line length expected(could be changes as per the user necessity)
        byte[] buf = new byte[lineLengthMax];//array to store the line
        int cnt = 0;//starting index for the buf array
        byte c;//used for reading the input
        while((c = read()) != -1){
          if(c == '\n')break;//if found a new line then break out of the loop
          buf[cnt++] = (byte) c;//else put the element to the buffer
        }
        return new String(buf, 0, cnt);
      }
 								
      //Method to return a string from the strea
      public String nextString() throws IOException{
		int stringLengthMax=(int)(1e6);//maximum necessary string length(could be changed if necessary)
		byte buf[]=new byte[stringLengthMax];//byte stream to store the string
		byte c=read();//to read the current input
		while(c<=' ')c=read();
		int cnt = 0;//starting index for the buf array
		do{
		  if(c == '\n' || c<=' ')break;//if found a new line or space then break out of the loop
		  buf[cnt++]=(byte)c;//else put the element into the buffer
		}while((c=read())!=-1);
		return new String(buf, 0, cnt);//return the string
      }
				
      //Method to read integers from the stream
      public int nextInt() throws IOException{
        int ret = 0;//Integer to be returned
        byte c = read();//read the starting element
        while(c <= ' ')c = read();//its main aim is to discard the white spaces
        boolean neg = (c == '-');//its there to check whether the number is negative or not
        if(neg)c = read();//if not included then the negative sign will be used as an integer
        //loop for reading till the last point of the integer
        do{
          ret = ret * 10 + c - '0';
        }while((c = read()) >= '0' && c <= '9');
 							
        if(neg)return -ret;//return the negative number if found negative
        return ret;//used to return the non-negative number
      }
 
      //Method to read long from the stream
      public long nextLong() throws IOException{
        long ret = 0;//Long to be returned
        byte c = read();//read the starting element
        while(c <= ' ')c = read();//its main aim is to discard the white spaces
        boolean neg = (c == '-');//used to find if the element is negative
        if(neg)c = read();//if not included then the negative sign will be used as a long
        //loop for reading till the last point of the long
        do{
          ret = ret * 10 + c - '0';
        }while((c = read()) >= '0' && c <= '9');
				
        if(neg)return -ret;//return the negative number if it is found negative
        return ret;//used to return the non negative number
      }
 				
      //Method to return double from the stream
      public double nextDouble() throws IOException{
      	double ret = 0;//Double to be returned
      	double div = 1;//Used for putting the numbers after the decimal point
        byte c = read();//read the starting element
        while(c <= ' ')c = read();//its main aim is to discard the white spaces
        boolean neg = (c == '-');//used to find if the element is negative
        if(neg)c = read();//if not included then the negative sign will be used as a double
        //loop for reading till the decimal of the double
        do{
          ret = ret * 10 + c - '0';
        }while((c = read()) >= '0' && c <= '9');
        //read after the decimal
        if(c == '.')
          while((c = read()) >= '0' && c <= '9')ret += (c - '0') / (div *= 10);          
						
        if(neg)return -ret;//return the negative number if it is found negative
        return ret;//used to return the non negative number
      }
				
      //Wrapping up method
      public void close() throws IOException{
       	if(din == null)return;//if there is no data input stream then no need to do anything
        din.close();//if there is a data input stream then flush it up
      }
    }
 		
		
    //Template.Main method which is not to be touched at any case
    public static void main(String...string) throws IOException{
      OutputStream outputStream = System.out;//Declaration of output stream
      InputReader in = new InputReader();//User defined InputReader class initialization
      PrintWriter out = new PrintWriter(outputStream);//Printwriter for fast output
      ProblemSolver problemSolver = new ProblemSolver();//User defined main class for solving the problem
      problemSolver.solveTheProblem(in, out);//User defined main method for solving the problem
      in.close();//Wrapping up
      out.close();//Wrapping up	  
    }
}
