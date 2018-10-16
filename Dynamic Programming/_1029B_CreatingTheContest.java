import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1029B_CreatingTheContest{
	public static void main(String...strings) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(in.nextToken());
		long[] difficulty=new long[n];
		in=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;++i)difficulty[i]=Long.parseLong(in.nextToken());
		
		int j=0,max=1;
		for(int i=0;i<n;++i){
			j=i;
			while(j+1<n && difficulty[j+1]<=difficulty[j]*2)++j;
			max=Math.max(max,j-i+1);
			i=j;
		}
		
		out.print(max);
		
		out.close();
	}
}