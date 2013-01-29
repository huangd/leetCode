package leetcode;

/**
 * User: huangd
 * Date: 1/28/13
 * Time: 11:04 PM
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices.length == 0) {
            return 0;
        }
        int[] front = new int[prices.length];
        int[] end = new int[prices.length];

        int min = prices[0];
        front[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            front[i] = Math.max(prices[i] - min, front[i - 1]);
        }

        int max = prices[prices.length - 1];
        end[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; --i) {
            max = Math.max(max, prices[i]);
            end[i] = Math.max(max - prices[i], end[i + 1]);
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, front[i] + end[i]);
        }
        return maxProfit;
    }
}
