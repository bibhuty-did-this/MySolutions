// https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&id=top-interview-150
// Time Complexity: O(n)
// Space Complexity: O(1)
public class JumpGame {
    public boolean canJump(int[] nums) {
        int i=0;
        int forward=nums[0];
        while(i<nums.length){
            --forward;
            if(forward<=nums[i]){
                forward=nums[i];
            }
            ++i;
            if(forward==0) break;
        }
        return i==nums.length;
    }
}
