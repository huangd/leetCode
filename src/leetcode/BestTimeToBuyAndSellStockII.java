package leetcode;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 5:48 PM
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }
}
