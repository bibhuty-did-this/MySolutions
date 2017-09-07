package codes;

import java.util.ArrayList;

public class Task165A_SupercentralPoint {
    int[] x;
    int[] y;
    int n;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n=in.nextInt();
        x=new int[n];
        y=new int[n];
        for(int i=0;i<n;++i){
            x[i]=in.nextInt();
            y[i]=in.nextInt();
        }
        int superCentralPoint=0;
        for(int pos=0;pos<n;++pos){
            if(up(pos) && down(pos) && left(pos) && right(pos))
                ++superCentralPoint;
        }
        out.print(superCentralPoint);

    }
    public boolean up(int pos){
        for(int j=0;j<n;++j)
            if (pos != j && x[pos] == x[j] && y[j] > y[pos])
                return true;
        return false;
    }
    public boolean down(int pos){
        for(int j=0;j<n;++j)
            if (pos != j && x[pos] == x[j] && y[j] < y[pos])
                return true;
        return false;
    }
    public boolean left(int pos){
        for(int i=0;i<n;++i)
            if(i!=pos && y[i]==y[pos] && x[pos]>x[i])
                return true;
        return false;
    }
    public boolean right(int pos){
        for(int i=0;i<n;++i)
            if(pos!=i && y[i]==y[pos] && x[pos]<x[i])
                return true;
        return false;
    }
}
