package codes;

public class Task602A_TwoBases {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),base=in.nextInt();
        long x=0;
        long power= (long) Math.pow(base,n-1);
        for(int i=0;i<n;++i){
            x+=power*in.nextInt();
            power/=base;
        }
        n=in.nextInt();
        base=in.nextInt();
        long y=0;
        power= (long) Math.pow(base,n-1);
        for(int i=0;i<n;++i){
            y+=power*in.nextInt();
            power/=base;
        }
        if(x==y)out.print("=");
        else if(x>y)out.print(">");
        else out.print("<");
    }
}
