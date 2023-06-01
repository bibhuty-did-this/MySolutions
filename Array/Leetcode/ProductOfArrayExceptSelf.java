// https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&id=top-interview-150
// Time Complexity: O(n)
// Space Complexity: O(1)
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n];
        answer[0]=1;
        answer[1]=nums[0];
        for(int i=2;i<n;++i){
            answer[i] = nums[i-1]*answer[i-1];
        }
        int leftProduct=nums[n-1];
        for(int i=n-2;i>=0;--i){
            answer[i]*=leftProduct;
            leftProduct*=nums[i];
        }
        return answer;
    }
}
