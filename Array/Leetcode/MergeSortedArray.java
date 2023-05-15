//https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&id=top-interview-150
public class MergeSortedArray {
    // Time Complexity = O(m+n)
    // Space Complexity = O(1)
    public void merge(int[] num1, int m, int[] num2, int n) {
        int i=m-1,j=n-1,max_idx = m+n-1;
        while(max_idx>=0){
            if(j<0) break;
            if((i>=0 && num1[i]>=num2[j])){
                num1[max_idx--] = num1[i--];
            } else {
                num1[max_idx--] = num2[j--];
            }
        }
    }
}
