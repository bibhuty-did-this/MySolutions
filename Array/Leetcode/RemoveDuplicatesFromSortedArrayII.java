//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&id=top-interview-150
// Time Complexity: O(N)
// Space Complexity: O(1)
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int i=0, n=nums.length;
        int pivot=0;
        int occurence=2;
        while(i<n){
            int current=i;
            int currentOccurence=0;
            int currentNumber=nums[i];
            while(i<n && nums[i]==currentNumber){
                ++currentOccurence;
                if(currentOccurence<=occurence){
                    nums[pivot++]=nums[i];
                }
                ++i;
            }
            if(current==i){
                nums[pivot++]=nums[i++];
            }
        }
        return pivot;
    }
}
