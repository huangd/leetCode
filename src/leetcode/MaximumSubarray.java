package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 10:27 PM
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i : A) {
            current = Math.max(current + i, i);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}
