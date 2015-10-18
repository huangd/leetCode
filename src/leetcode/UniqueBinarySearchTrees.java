package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: huangd
 * Date: 12/29/12
 * Time: 11:05 AM
 */
public class UniqueBinarySearchTrees {

    List<Integer> numTreesCache = new ArrayList<>();

    //Recursive is very good here. It used * instead of the regular +
    public int numTrees(int n) {
        if (numTreesCache.size() > n) {
            return numTreesCache.get(n);
        }
        if (n == 0) {
            numTreesCache.add(n, 1);
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += numTrees(i) * numTrees(n - i - 1);
        }
        numTreesCache.add(n, sum);
        return sum;
    }
}
