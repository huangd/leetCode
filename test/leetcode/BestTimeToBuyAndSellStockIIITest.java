package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 1/28/13
 * Time: 11:25 PM
 */
public class BestTimeToBuyAndSellStockIIITest {
    @Test
    public void testMaxProfit() throws Exception {
        int[] prices = {1, 2};
        BestTimeToBuyAndSellStockIII bestTimeToBuyAndSellStockIII = new BestTimeToBuyAndSellStockIII();
        assertEquals(1, bestTimeToBuyAndSellStockIII.maxProfit(prices));
    }
}
