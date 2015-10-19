package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 12/29/12
 * Time: 11:20 AM
 */
public class UniquePaths {

    Map<String, Integer> pathCountCache = new HashMap<>();

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        String cacheKey = m + "," + n;
        int pathCount = pathCountCache.get(cacheKey) == null ? uniquePaths(m - 1, n) + uniquePaths(m, n - 1) : pathCountCache.get(cacheKey);
        pathCountCache.put(cacheKey, pathCount);
        return pathCount;
    }
}
