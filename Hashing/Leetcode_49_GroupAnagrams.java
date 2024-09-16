import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class Leetcode_49_GroupAnagrams {
    public static void main(String...args){
        var in = new Scanner(System.in);
        var line = in.nextLine();
        var strs=line.substring(1,line.length()-1).split(",");
        // System.out.println(Arrays.toString(strs));
        var anagrams = groupAnagrams(strs);
        in.close();
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        var map=new HashMap<String,List<String>>();
        for(var str:strs){
            var letters = str.toCharArray();
            Arrays.sort(letters);
            var key = new String(letters);
            map.putIfAbsent(key,new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    
}
