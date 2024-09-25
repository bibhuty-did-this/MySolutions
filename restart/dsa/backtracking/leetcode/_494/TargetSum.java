package restart.dsa.backtracking.leetcode._494;

import java.util.LinkedList;
import java.util.Queue;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target){
        int lastNum=nums[nums.length-1];
        Queue<Integer> sums=new LinkedList<>(){{
            add(lastNum);
            add(-lastNum);
        }};
        for(int i=nums.length-2;i>=0;--i){
            int currentLen = sums.size();
            for(int j = 0; j< currentLen;++j){
                int sum=sums.poll();
                sums.offer(sum+nums[i]);
                sums.offer(sum-nums[i]);
            }
        }
        int total=0;
        while (!sums.isEmpty()){
            if(sums.poll()==target)++total;
        }
        return total;
    }
    public int _findTargetSumWays(int[] nums, int target){
        return _findTargetSumWays(nums, 0, target, 0);
    }

    private int _findTargetSumWays(int[] nums, int index, int target, int result){
        if(index==nums.length){
            return result==target ? 1 : 0;
        }
        return _findTargetSumWays(nums, index+1, target, result+nums[index]) + _findTargetSumWays(nums, index+1, target, result-nums[index]);
    }

    public static void main(String[] args) {
        var solution=new TargetSum();
        System.out.println(solution.findTargetSumWays(new int[]{38,16,35,13,26,35,17,42,42,39,10,35,38,27,0,22,30,22,3,5},11));
        System.out.println(solution.findTargetSumWays(new int[]{1},1));
    }
}
