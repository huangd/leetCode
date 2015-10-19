package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 8:14 PM
 */
public class MinimumPathSum {

    Map<String, Integer> cache = new HashMap<>();

    public int minPathSum(int[][] grid) {
        return minPathSum(grid.length - 1, grid[0].length - 1, grid);
    }

    int minPathSum(int m, int n, int[][] grid) {
        String cacheKey = m + "," + n;
        if (cache.get(cacheKey) != null) return cache.get(cacheKey);

        if (m == 0 && n == 0) return grid[m][n];

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (m > 0) down = minPathSum(m - 1, n, grid);
        if (n > 0) right = minPathSum(m, n - 1, grid);
        cache.put(cacheKey, grid[m][n] + Math.min(down, right));
        return cache.get(cacheKey);
    }
}
