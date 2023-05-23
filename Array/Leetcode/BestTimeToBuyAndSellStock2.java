// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&id=top-interview-150
// Time Complexity: O(n)
// Space Complexity: O(1)
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=prices.length-2;i>=0;--i){
            profit+=Math.max(0,prices[i+1]-prices[i]);
        }
        return profit;
    }
}
