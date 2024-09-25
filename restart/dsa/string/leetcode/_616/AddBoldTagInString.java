package restart.dsa.string.leetcode._616;

public class AddBoldTagInString {
    public String addBoldTag(String s, String[] words){
        int n=s.length();
        boolean[] isPartOfSubstring=new boolean[n];
        for(String word:words) markOccurrence(s, word, isPartOfSubstring);
        boolean boldBegin=false;
        var result=new StringBuilder();
        for(int i=0;i<n;++i){
            if(isPartOfSubstring[i] && !boldBegin){
                boldBegin=true;
                result.append("<b>");
            }else if(!isPartOfSubstring[i] && boldBegin){
                result.append("</b>");
                boldBegin=false;
            }
            result.append(s.charAt(i));
        }
        if(boldBegin) result.append("</b>");
        return result.toString();
    }

    public void markOccurrence(String s, String word, boolean[] isPartOfSubstring){
        int fromIndex=0;
        while(s.indexOf(word,fromIndex)!=-1){
            fromIndex=s.indexOf(word,fromIndex);
            for(int i=0;i<word.length();++i){
                isPartOfSubstring[fromIndex+i]=true;
            }
            ++fromIndex;
        }
    }
    public static void main(String[] args) {
        var solution=new AddBoldTagInString();
        System.out.println(solution.addBoldTag("aaabbb",new String[]{"aa","b"}));
        System.out.println(solution.addBoldTag("abcxyz123",new String[]{"abc","123"}));
    }
}
