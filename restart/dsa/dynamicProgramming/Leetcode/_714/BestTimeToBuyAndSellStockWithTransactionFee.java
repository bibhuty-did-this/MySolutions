package restart.dsa.dynamicProgramming.Leetcode._714;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] price, int fee){
        int i=0, n=price.length;
        int low=Integer.MAX_VALUE, high=low, profit=0;
        while(i<n){
           if(price[i]>=high){
                high=price[i];
            }else{
                if(high-low>fee && high-price[i]>fee){
                    profit+=(high-low-fee);
                    low=price[i];
                    high=low;
                }else{
                    if(low>price[i]){
                        low=price[i];
                        high=low;
                    }
                }
            }
            ++i;
        }
        if(high-low>fee) profit+=(high-low-fee);
        return profit;
    }

    public static void main(String[] args) {
        var solution=new BestTimeToBuyAndSellStockWithTransactionFee();
        System.out.println(solution.maxProfit(new int[]{1,3,2,8,4,9},2));;
        System.out.println(solution.maxProfit(new int[]{1,3,7,5,10,3},3));;
    }
}
