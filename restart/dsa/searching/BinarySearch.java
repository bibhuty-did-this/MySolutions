package restart.dsa.searching;

public class BinarySearch {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    // NOTE: Binary Search only works on sorted array
    public static int binarySearch(int[] array, int num, int start, int end){
        if(start>end) return start; // Spillage will only occur when there's no element found
        int mid=start+(end-start)/2;
        if(array[mid]>num) return binarySearch(array, num, start, mid-1);
        else if(array[mid]<num) return binarySearch(array, num, mid+1, end);
        else return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int index = binarySearch(arr, 5, 0, arr.length - 1);
        System.out.println(index);  // Output: 2 (5 is at index 2)

        arr = new int[]{1, 3, 5, 7, 9};
        index = binarySearch(arr, 6, 0, arr.length - 1);
        System.out.println(index);  // Output: 3 (6 should be inserted at index 3)

        arr = new int[]{1, 3, 5, 7, 9};
        index = binarySearch(arr, 0, 0, arr.length - 1);
        System.out.println(index);  // Output: 0 (0 should be inserted at index 0)

        arr = new int[]{1, 3, 5, 7, 9};
        index = binarySearch(arr, 10, 0, arr.length - 1);
        System.out.println(index);  // Output: 5 (10 should be inserted at index 5)
    }
}
