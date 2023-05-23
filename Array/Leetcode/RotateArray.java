// https://leetcode.com/problems/rotate-array/editorial/?envType=study-plan-v2&id=top-interview-150
// Time Complexity: O(n)
// Space Complexity: O(1)
public class RotateArray {
    public void rotateNow(int[] nums, int k) {
        int n = nums.length;
        int count = 0, step = k%n;
        int current = step, begin = 0;
        int temp = nums[0];
        while(count<n){
            if(current==begin){
                ++begin;
                nums[current] = temp;
                begin=(++current)%n;
                temp = nums[begin];
            }else{
                int buffer = nums[current];
                nums[current] = temp;
                temp = buffer;
            }
            ++count;
            current = (current+step)%n;
        }
    }

    // Reverse the entire array
    // Reverse the first k element
    // Reverse the last n-k element
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int nums[], int start, int end){
        while(start<end){
            int temp = nums[end];
            nums[end--]=nums[start];
            nums[start++]=temp;
        }
    }
}
