package SummaryRanges;

import java.util.List;
import java.util.ArrayList;

public class Leetcode_228_SummaryRanges {
    public static void main(String...args){
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
    public static List<String> summaryRanges(int[] nums) {
        int i=0,n=nums.length;
        var ranges=new ArrayList<String>();
        while(i<n){
            int start=nums[i],end=start;
            while(i+1<n && nums[i+1]-nums[i]==1){
                ++i;
            }
            end=nums[i];
            if(start==end) ranges.add(Integer.toString(start));
            else ranges.add(Integer.toString(start)+"->"+Integer.toString(end));
            ++i;
        }
        return ranges;
    }
}
