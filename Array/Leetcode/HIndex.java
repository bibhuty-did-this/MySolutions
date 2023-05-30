import java.util.Arrays;

// https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&id=top-interview-150
// Time Complexity: O(nlogn)
// Space Complexity: O(n)
public class HIndex {
    public int hIndex(int[] citations) {
        int n=citations.length;
        Arrays.sort(citations);
        int hIndex=0;
        for(int i=1;i<=n;++i)
            if(citations[n-i]>=i)
                hIndex=i;
        return hIndex;
    }
}
