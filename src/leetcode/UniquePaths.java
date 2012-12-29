package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 12/29/12
 * Time: 11:20 AM
 */
public class UniquePaths {

    private Map<String, Integer> cache;

    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        cache = new HashMap<String, Integer>();
        return totalPaths(m - 1, n - 1);
    }

    private int totalPaths(int x, int y) {
        Integer number = cache.get(x + "," + y);
        if (number != null) {
            return number;
        }
        if (x == 0 && y == 0) {
            return 1;
        } else {
            int down = 0;
            if (y != 0) {
                down = totalPaths(x, y - 1);
            }
            int left = 0;
            if (x != 0) {
                left = totalPaths(x - 1, y);
            }
            number = down + left;
            cache.put(x + "," + y, number);
            return number;
        }
    }
}
