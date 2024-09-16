import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class Leetcode_30_SubstringWithConcatenationOfAllWords {
    
    public static void main(String...args){
        System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"}));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int wn=words[0].length(), n=s.length();
        var map=new HashMap<String,Integer>();
        var imap=new HashMap<String,Integer>();
        var indices=new ArrayList<Integer>();
        for(var word:words){
            if(map.containsKey(word))map.put(word,map.get(word)+1);
            else map.put(word,1);
        }
        // "wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}
        for(int i=0;i<wn;++i){
            int left=i,right=i,count=0;
            while(left<n){
                var word=s.substring(right,Math.min(right+wn, n));
                if(imap.containsKey(word))imap.put(word,imap.get(word)+1);
                else imap.put(word,1);
                if(map.containsKey(word)){
                    if(map.get(word)>=imap.get(word)){
                        ++count;
                        right+=wn;
                    }else{
                        var currentWord=s.substring(left,left+wn);
                        imap.put(word,imap.get(word)-1);
                        if(!currentWord.equals(word)){
                            --count;                           
                        }
                        imap.put(currentWord, imap.get(currentWord)-1);
                        left+=wn;
                    }
                    if(count==words.length){
                        indices.add(left);
                    }
                }else{
                    right+=wn;
                    left=right;
                    count=0;
                    imap.clear();
                }
            }
        }
        return indices;
    }
}
