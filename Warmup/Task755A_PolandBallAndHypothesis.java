package codes;

public class Task755A_PolandBallAndHypothesis {
    public void solve(int testNumber, InputReader in, OutputWriter out){
        int n=in.nextInt();
        if(n==1){
            out.print(3);
            return;
        }
        if(n%2==1)out.print(1);
        else{
            for(int i=1;i<1000;++i){
                if(!isPrime(n*i+1)){
                    out.print(i);
                    return;
                }
            }
        }
    }
    public boolean isPrime(int number){
        int limit=(int)Math.sqrt(number);
        for(int i=3;i<=limit;++i){
            if(number%i==0)return false;
        }
        return true;
    }
}
