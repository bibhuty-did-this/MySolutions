package restart.dsa.math;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public boolean[] markAllPrimesLessThanOrEqualToN(int nums){
        boolean[] isPrime=new boolean[nums+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int num=2;num*num<=nums;++num){
            if(isPrime[num]){
                int current=num*num;// Because num*(something less than num) is already done
                while (current<=nums){
                    isPrime[current]=false;
                    current+=num;
                }
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        var solution=new SieveOfEratosthenes();
        boolean[] markedPrimes = solution.markAllPrimesLessThanOrEqualToN(499979);
        for(int i=0;i<markedPrimes.length;++i){
            if(markedPrimes[i]){
                System.out.println(i);
            }
        }
    }
}
