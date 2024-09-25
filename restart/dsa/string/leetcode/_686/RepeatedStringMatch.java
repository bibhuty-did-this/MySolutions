package restart.dsa.string.leetcode._686;

public class RepeatedStringMatch {

    /**
     *
     * In order for a valid answer to be present
     * b = suffix(a)+(x*a)+prefix(a)
     *
     * @param a
     * @param b
     * @return min occurence of a such that b is substring of a or -1
     */
    public int repeatedStringMatch(String a,String b){
        var repeat=new StringBuilder();
        while(repeat.length()<=b.length()){
            repeat.append(a);
            if(repeat.indexOf(b)!=-1) return repeat.length()/a.length();
        }
        repeat.append(a);
        return repeat.indexOf(b)!=-1 ? repeat.length()/a.length() : -1;
    }
    public static void main(String[] args) {
        var solution=new RepeatedStringMatch();
        System.out.println(solution.repeatedStringMatch("abcd","cdabcdab"));
        System.out.println(solution.repeatedStringMatch("a","aa"));
        System.out.println(solution.repeatedStringMatch("abcd","dabcda"));
        System.out.println(solution.repeatedStringMatch("abcd","cdab"));
        System.out.println(solution.repeatedStringMatch("axaxaya","axaya"));
    }
}
