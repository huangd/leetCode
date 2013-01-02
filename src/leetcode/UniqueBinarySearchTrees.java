package leetcode;

/**
 * User: huangd
 * Date: 12/29/12
 * Time: 11:05 AM
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += numTrees(i) * numTrees(n - i - 1);
        }
        return sum;
    }
}
