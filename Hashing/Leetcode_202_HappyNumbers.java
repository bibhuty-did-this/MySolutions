import java.util.HashSet;
public class Leetcode_202_HappyNumbers {
    public boolean isHappy(int n){
        var set=new HashSet<Integer>();
        int num=n;
        while(!set.contains(num)){
            if(num==1) return true;
            set.add(num);
            int sum=0;
            while(num!=0){
                int digit=num%10;
                sum+=(digit*digit);
                num/=10;
            }
            num=sum;
        }
        return false;
    }
}
