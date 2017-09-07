package codes;

public class Task353A_Domino {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        int[] upper=new int[n];
        int[] lower=new int[n];
        int upperSum=0;
        int lowerSum=0;
        for(int i=0;i<n;++i){
            upper[i]=in.nextInt();
            lower[i]=in.nextInt();
            upperSum+=upper[i];
            lowerSum+=lower[i];
        }
        if(upperSum%2==0 && lowerSum%2==0)out.print(0);
        else if((upperSum%2==0 && lowerSum%2==1)||(upperSum%2==1 && lowerSum%2==0))out.print(-1);
        else{
            if(n!=1){
                for(int i=0;i<n;++i){
                    if(lower[i]%2==1 && upper[i]%2==0){
                        out.print(1);
                        return;
                    }else if(lower[i]%2==0 && upper[i]%2==1){
                        out.print(1);
                        return;
                    }
                }
                out.print(-1);
            }else out.print(-1);

        }
    }
}
