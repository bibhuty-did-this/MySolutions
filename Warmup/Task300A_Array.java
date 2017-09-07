package codes;

import java.util.ArrayList;
import java.util.Stack;

public class Task300A_Array {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        Stack<Integer> positive=new Stack<>();
        Stack<Integer> negative=new Stack<>();
        int zero=0;
        while(n-->0){
            int get=in.nextInt();
            if(get>0)positive.push(get);
            else if(get<0)negative.push(get);
            else ++zero;
        }
        out.printLine(1,negative.pop());
        if(positive.isEmpty()){
            out.printLine(2,negative.pop(),negative.pop());
        }else{
            out.print(positive.size(),"");
            while(!positive.isEmpty())out.print(positive.pop(),"");
            out.printLine();
        }
        out.print(zero+negative.size(),"");
        while(!negative.isEmpty())out.print(negative.pop(),"");
        while(zero-->0)out.print(0,"");

    }
}
