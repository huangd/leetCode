package leetcode;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 4:09 PM
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = Integer.MIN_VALUE;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] > height[j] ? height[j] : height[i];
            int current = minHeight * (j - i);
            if (current > max) {
                max = current;
            }

            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return max;
    }
}
