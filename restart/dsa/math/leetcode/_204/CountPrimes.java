package restart.dsa.math.leetcode._204;

public class CountPrimes {

    public int countPrimesLessThanNumbers(int limit){
        int count=0;
        if(limit<=2) return count;
        boolean[] notPrime=new boolean[limit];
        for(int i=2;i<=Math.sqrt(limit);++i){
            if(!notPrime[2]){
                for (int j=i*i;j<limit;j+=i){
                    notPrime[j]=true;
                }
            }
        }
        for(int i=2;i<limit;++i) count+=(notPrime[i] ? 0 : 1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimesLessThanNumbers(11));
    }
}
