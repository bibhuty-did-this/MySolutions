import java.util.HashMap;
public class Leetcode_128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums){
        var length=0;
        var map=new HashMap<Integer,Integer>();
        for(var num:nums)map.put(num, map.getOrDefault(num,0)+1);
        for(var num:nums){
            if(map.getOrDefault(num, 0)>0){
                int tempLen=0;
                int frontKey=num,backKey=num-1;
                while(map.getOrDefault(frontKey, 0)>0){
                    ++tempLen;
                    map.put(frontKey, map.get(frontKey)-1);
                    ++frontKey;
                }
                while(map.getOrDefault(backKey, 0)>0){
                    ++tempLen;
                    map.put(backKey, map.get(backKey)-1);
                    --backKey;
                }
                length=Math.max(length,tempLen);
            }
        }
        return length;
    } 
}
