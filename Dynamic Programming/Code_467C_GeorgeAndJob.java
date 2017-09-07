import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Code_467C_GeorgeAndJob{

    static long[][] dp;
    static long[] sum;
    static int n,interval,pairs;

    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        n=in.nextInt();
        interval=in.nextInt();
        pairs=in.nextInt();

        sum=new long[n];
        sum[0]=in.nextLong();
        for(int i=1;i<n;++i)
            sum[i]=sum[i-1]+in.nextLong();

        dp=new long[n][pairs+1];
        for(int i=0;i<n;++i)
            Arrays.fill(dp[i],-1);

        out.print(maxSum(0,pairs));

        out.close();
    }
    
    public static long maxSum(int index,int remaining){

        /**
         * If there is no element left to take then it is better
         * not to add anything extra to the sum
         */
        if(remaining==0)
            return 0;

        /**
         * It is not possible to go out of index. So in case we
         * encounter this case then we should return a very min
         * value which could be further modified with ease
         */
        if(index>=n)
            return Integer.MIN_VALUE;

        /**
         * This step is being implemented to avoid recalculation
         * of anything which is already calculated. This is the
         * main part of dp i.e. MEMORIZATION.
         *
         * It is the only thing making the dp efficient by decreasing
         * the time complexity
         */
        if(dp[index][remaining]!=-1)
            return dp[index][remaining];

        /**
         * This statement specifies that if the current index can't
         * provide the required answer then we need to go to the
         * next index and find for k elements
         */
        long ans=maxSum(index+1,remaining);

        /**
         * This step indicates that if it is possible to take the
         * sum of the interval from current index for a possible
         * answer
         */
        if(index+interval<=n){
            /**
             * This step stores the current sum of the interval at the
             * current index
             */
            long currentSum=sum[index+interval-1]-(index>0?sum[index-1]:0);

            /**
             * This step gives determines if the current interval could
             * be taken as answer of it has to be left. In case we find
             * the current interval as a possibility then we should proceed
             * to the next step for next possible pairs(remaining-1) along with
             * the sum of the current interval(currentSum)
             */
            ans=Math.max(ans,maxSum(index+interval,remaining-1)+currentSum);
        }

        return dp[index][remaining]=ans;
        
    }
}