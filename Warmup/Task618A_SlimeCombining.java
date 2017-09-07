package codes;

public class Task618A_SlimeCombining {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        int current=(int)(Math.log(n)/Math.log(2));
        for(int i=current;i>=0 && n>0;--i){
            if(Math.pow(2,i)<=n){
                out.print(i+1,"");
                n-=Math.pow(2,i);
            }
        }
    }
}
