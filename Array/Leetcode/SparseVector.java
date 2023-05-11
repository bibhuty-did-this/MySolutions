import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/editorial/
public class SparseVector {

    // Time complexity of array creation - O(n)
    // Time complexity of dot product - O(L1+L2)
    // Space complexity of array creation - O(Li)
    // Space complecity of dot product - O(1)
    List<int[]> list;
    public SparseVector(int[] nums) {
        list = new ArrayList<>();
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=0){
                list.add(new int[]{i,nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct = 0;
        int p=0,q=0;
        while(p<list.size() && q<vec.list.size()){
            if(list.get(p)[0]==vec.list.get(q)[0]){
                dotProduct += (list.get(p)[1]*vec.list.get(q)[1]);
                ++p;
                ++q;
            } else if(list.get(p)[0]>vec.list.get(q)[0]){
                ++q;
            } else {
                ++p;
            }
        }
        return dotProduct;
    }

    // Follow up what if one of the matrix is not sparse
    public int nonSparseDotProduct(SparseVector vec) {
        int dotProduct = 0;
        int p=0,q=0;
        while(p<list.size() && q<vec.list.size()){
            if(list.get(p)[0]==vec.list.get(q)[0]){
                dotProduct += (list.get(p)[1]*vec.list.get(q)[1]);
                ++p;
                ++q;
            } else if(list.get(p)[0]>vec.list.get(q)[0]){
                ++q;
            } else {
                ++p;
            }
        }
        return dotProduct;
    }
}
