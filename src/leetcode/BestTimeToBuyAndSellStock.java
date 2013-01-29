package leetcode;

/**
 * User: huangd
 * Date: 1/28/13
 * Time: 10:16 PM
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
