package restart.dsa.sorting;

import java.util.Arrays;

public class MergeSort {

    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public void mergeSort(int[] array, int start, int end){
        if(start>=end) return;
        int mid=(start+end)/2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1,end);
        int ln=mid-start+1, rn=end-mid;
        int[] left=new int[ln], right=new int[rn];
        for(int i=0;i<ln;++i) left[i]=array[start+i];
        for(int i=0;i<rn;++i) right[i]=array[mid+1+i];
        int i=0, j=0, k=start;
        while(i<ln && j<rn){
            if(left[i]<right[j]) array[k++]=left[i++];
            else array[k++]=right[j++];
        }
        while(i<ln) array[k++]=left[i++];
        while(j<rn) array[k++]=right[j++];
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();

        // Test cases
        int[] test1 = {5, 2, 9, 1, 5, 6};  // Unsorted array with duplicates
        int[] test2 = {};                 // Empty array
        int[] test3 = {3};                // Single element
        int[] test4 = {1, 2, 3, 4, 5};    // Already sorted array
        int[] test5 = {5, 4, 3, 2, 1};    // Reversed array
        int[] test6 = {7, -2, 4, 8, 1, 0, -1, 3}; // Array with negative numbers

        // Run the merge sort and print the results
        sorter.runTest(test1);
        sorter.runTest(test2);
        sorter.runTest(test3);
        sorter.runTest(test4);
        sorter.runTest(test5);
        sorter.runTest(test6);
    }

    public void runTest(int[] array) {
        System.out.println("Original Array: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted Array:   " + Arrays.toString(array));
        System.out.println();
    }
}
