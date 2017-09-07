package codes;

import java.util.ArrayList;

public class Task224A_Parallelepiped {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int ab=in.nextInt(),bc=in.nextInt(),ca=in.nextInt();
        for(int i=1;i<=ab;++i){
            if(ab%i==0){
                int a=i;
                int b=ab/a;
                if(bc%b==0 && ca%a==0 && bc/b==ca/a){
                    out.print(4*(a+b+bc/b));
                    return;
                }
            }
        }
    }
}
