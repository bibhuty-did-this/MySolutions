package codes;

import java.util.HashSet;
import java.util.Set;

public class Task745A_HongcowLearnsTheCyclicShift {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s=in.next();
        Set<String> words=new HashSet<>();
        words.add(s);
        int n=s.length();
        for(int i=1;i<n;++i){
            s=Character.toString(s.charAt(n-1)).concat(s.substring(0,n-1));
            words.add(s);
        }
        out.print(words.size());
    }
}
