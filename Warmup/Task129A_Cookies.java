package codes;

public class Task129A_Cookies {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        int counter=0;
        for(int i=0;i<n;++i)
            if(in.nextInt()%2==1)
                ++counter;
        if(counter%2==0)out.print(n-counter);
        else out.print(counter);
    }
}
