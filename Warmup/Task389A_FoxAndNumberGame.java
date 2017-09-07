package codes;

import java.util.Arrays;

public class Task389A_FoxAndNumberGame {
    int n;
    int[] x;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n=in.nextInt();
        x=in.nextIntArray(n);
        while(!isEqual()){
            Arrays.sort(x);
            subtract();
        }
        out.print(x[0]*n);
    }
    public boolean isEqual(){
        int value=x[0];
        for(int i=0;i<n;++i)
            if(x[i]!=value)
                return false;
        return true;
    }
    public void subtract(){
        for(int i=n-1;i>0;--i){
            if(x[i]!=x[i-1]){
                x[i]-=x[i-1];
            }
        }
    }
}
