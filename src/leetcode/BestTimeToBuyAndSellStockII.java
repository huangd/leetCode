package leetcode;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 5:48 PM
 */
public class BestTimeToBuyAndSellStockII {

    private boolean isShareHolder;
    private int buyPrice;

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        isShareHolder = false;
        return getMaxProfit(prices);
    }

    private int getMaxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (buyOrSell(prices, i) == 1 && !isShareHolder) {
                buyPrice = prices[i];
                isShareHolder = true;
            } else if (buyOrSell(prices, i) == -1 && isShareHolder) {
                profit += prices[i] - buyPrice;
                isShareHolder = false;
            }
        }
        return profit;
    }

    private int buyOrSell(int[] prices, int index) {
        if (prices.length <= 1) {
            return 0;
        } else {
            if (index == 0) {
                if (prices[index + 1] > prices[index]) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (index == prices.length - 1) {
                if (prices[index] > prices[index - 1]) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                if (prices[index] < prices[index + 1] && prices[index] <= prices[index - 1]) {
                    return 1;
                } else if (prices[index] >= prices[index + 1] && prices[index] > prices[index - 1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
