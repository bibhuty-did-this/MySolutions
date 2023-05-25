// https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&id=top-interview-150
// Time Complexity: O(n)
// Space Complexity: O(1)
public class JumpGameII {
    public int jump(int[] nums) {
        int currentMax=1, nextMax=0, i=0, jumps=0;
        while(i<nums.length){
            if(currentMax==0){
                currentMax=nextMax;
                ++jumps;
            }
            --currentMax;
            --nextMax;
            if(nextMax<nums[i]){
                nextMax=nums[i];
            }
            ++i;
        }
        return jumps;
    }
}
