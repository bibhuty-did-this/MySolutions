package restart.dsa.trie.leetcode._3043;

public class FindTheLengthOfTheLongestCommonPrefix {

    Trie node=new Trie();
    int maxDepth=0;

    class Trie{
        public Trie[] number=new Trie[10];
        public boolean inArr1=false,inArr2=false;
    }

    public void insert(int num, boolean inArr1, boolean inArr2) {
        String val=String.valueOf(num);
        Trie current=node;
        for(int i=0;i<val.length();++i){
            int index = val.charAt(i) - '0';
            if(current.number[index]==null){
                current.number[index]=new Trie();
            }
            current=current.number[index];
            if(inArr1) current.inArr1=true;
            if(inArr2) current.inArr2=true;
            if(current.inArr1 && current.inArr2){
                maxDepth=Math.max(i+1,maxDepth);
            }
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2){
        for(int num: arr1) insert(num, true, false);
        for(int num: arr2) insert(num, false, true);
        return maxDepth;
    }
    public static void main(String[] args) {
        var solution=new FindTheLengthOfTheLongestCommonPrefix();
        //System.out.println(solution.longestCommonPrefix(new int[]{1,10,100},new int[]{1000}));;
        //System.out.println(solution.longestCommonPrefix(new int[]{1,2,3},new int[]{4,4,4}));;
    }
}
