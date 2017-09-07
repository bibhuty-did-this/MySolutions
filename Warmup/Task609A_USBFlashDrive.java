package codes;

import java.util.Arrays;

public class Task609A_USBFlashDrive {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),m=in.nextInt();
        int size[]=in.nextIntArray(n);
        Arrays.sort(size);
        int sum=0,i=n-1,total=0;
        while(sum<m){
            sum+=size[i];
            ++total;
            --i;
        }
        out.printLine(total);
    }
}
