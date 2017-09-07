/**
 * Author: o_panda_o
 * Email: emailofpanda@yahoo.com
 */

import java.util.Arrays;
import java.util.Scanner;

public class MXMEDIAN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int a[]=new int[2*n+1];
            for(int i=1;i<=2*n;++i)
                a[i]=in.nextInt();
            Arrays.sort(a,1,2*n+1);
            System.out.println(a[n+(n+1)/2]);
            for(int i=1;i<=n;++i){
                System.out.print(a[i]+" "+a[n+i]+" ");
            }
            System.out.println();
        }
    }
}
