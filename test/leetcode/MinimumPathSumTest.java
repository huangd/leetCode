package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 3/2/13
 * Time: 12:40 PM
 */
public class MinimumPathSumTest {
    @Test
    public void testMinPathSum() throws Exception {
        int[][] grid = {{1, 2}, {1, 1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int minSum = minimumPathSum.minPathSum(grid);
        assertEquals(3, minSum);
    }
}
