import java.util.HashSet;
public class Leetcode_2743_CountSubstringsWithoutRepeatingCharacter{
    public int numberOfSpecialSubstrings(String s){
        int total=0, left=0, right=left;
        var set=new HashSet<Character>();
        while(left<s.length()){
            if(right<s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                ++right;
                ++total;
            }else{
                ++left;
                right=left;
                set.clear();
            }
        }
        return total;
    }
}