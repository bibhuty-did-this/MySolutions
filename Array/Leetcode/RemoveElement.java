//https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&id=top-interview-150
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int n = nums.length,last = n - 1;
        for(int i=0;i<n;++i) if(nums[i]==val) ++count;
        for(int i=0;i<(n-count);++i){
            if(nums[i]==val){
                while(nums[last]==val){
                    --last;
                    if(last<0)last = n-1;
                };
                nums[i]=nums[last--];
            }
        }
        return (n-count);
    }
}
