package leetcode;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 4:09 PM
 */
public class ContainerWithMostWater {
    //This solution is too slow.
    //TODO
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = Integer.MIN_VALUE;
        for (int from = 0; from < height.length; ++from) {
            int area = maxArea(height, from);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    private int maxArea(int[] height, int from) {
        int max = Integer.MIN_VALUE;
        for (int i = from; i < height.length; ++i) {
            int minHeight = Math.min(height[from], height[i]);
            int area = minHeight * (i - from);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }
}
