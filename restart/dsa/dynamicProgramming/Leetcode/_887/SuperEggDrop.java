package restart.dsa.dynamicProgramming.Leetcode._887;

/**
 * https://leetcode.com/problems/super-egg-drop/
 */
public class SuperEggDrop {
    public int superEggDrop(int eggs, int floors) {
        int[][] dp=new int[floors+1][eggs+1];
        for(int floor=1;floor<=floors;++floor){
            for(int egg=1;egg<=eggs;++egg){
                if(egg==1){
                    dp[floor][egg]=floor;
                }else if(floor==1){
                    dp[floor][egg]=1;
                }else{
                    int min=Integer.MAX_VALUE;
                    for(int currentFloor=1;currentFloor<=floor;++currentFloor){
                        min=Math.min(min, 1+ Math.max(dp[currentFloor-1][egg-1],dp[floor-currentFloor][egg]));
                    }
                    dp[floor][egg]=min;
                }
            }
        }
        return dp[floors][eggs];
    }

    public int superEggDropOptimal(int eggs, int floors) {
        int[][] dp = new int[floors + 1][eggs + 1];

        // Base cases: If there's only one egg, the worst-case is to drop from every floor (linear search).
        for (int floor = 1; floor <= floors; ++floor) {
            dp[floor][1] = floor;
        }

        // If there's only one floor, only one drop is needed regardless of the number of eggs.
        for (int egg = 1; egg <= eggs; ++egg) {
            dp[1][egg] = 1;
        }

        // Start filling the DP table using binary search to minimize the worst-case drops.
        for (int floor = 2; floor <= floors; ++floor) {
            for (int egg = 2; egg <= eggs; ++egg) {
                int low = 1, high = floor;
                int minDrops = Integer.MAX_VALUE;

                // Binary search for the optimal floor to drop the egg from.
                while (low <= high) {
                    int mid = (low + high) / 2;

                    // Two possibilities:
                    // 1. Egg breaks, we are left with mid - 1 floors and egg - 1 eggs.
                    // 2. Egg doesn't break, we are left with floor - mid floors and the same number of eggs.
                    int eggBreaks = dp[mid - 1][egg - 1];
                    int eggDoesntBreak = dp[floor - mid][egg];

                    // We take the worst of both scenarios.
                    int worstCase = 1 + Math.max(eggBreaks, eggDoesntBreak);

                    // Now, we want to minimize the worst case.
                    minDrops = Math.min(minDrops, worstCase);

                    // Binary search adjustment:
                    if (eggBreaks > eggDoesntBreak) {
                        high = mid - 1; // Search in the lower half.
                    } else {
                        low = mid + 1; // Search in the upper half.
                    }
                }
                dp[floor][egg] = minDrops;
            }
        }

        // The result for 'floors' floors and 'eggs' eggs.
        return dp[floors][eggs];
    }

    public static void main(String[] args) {
        var solution=new SuperEggDrop();
        System.out.println(solution.superEggDrop(1,2));
        System.out.println(solution.superEggDrop(2,2));
        System.out.println(solution.superEggDrop(2,6));
        System.out.println(solution.superEggDrop(3,14));
    }
}
