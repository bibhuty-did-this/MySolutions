// https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&id=top-interview-150
// Time Complexity: O(n)
// Space Complecity: O(1)
public class MajorityElement_BoyerMooreAlgo {
    public int majorityElement(int[] nums) {
        // Using Boyer Moore Algorithm
        int candidate=0;
        int count=0;
        for(int num:nums){
            if(count==0){
                candidate = num;
            }
            count+=(candidate==num?1:-1);
        }
        return candidate;
    }
}
