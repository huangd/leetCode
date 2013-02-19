package leetcode;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 8:38 PM
 */
public class TrappingRainWater {

    private int[] leftMax;
    private int[] rightMax;

    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        init(A);
        int sum = 0;
        for (int i = 0; i < A.length; ++i) {
            int minBar = Math.min(leftMax[i], rightMax[i]);
            sum += Math.max(0, minBar - A[i]);
        }
        return sum;
    }

    private void init(int[] A) {
        int currentMax = 0;
        leftMax = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            leftMax[i] = currentMax;
            currentMax = Math.max(currentMax, A[i]);
        }
        currentMax = 0;
        rightMax = new int[A.length];
        for (int i = A.length - 1; i >= 0; --i) {
            rightMax[i] = currentMax;
            currentMax = Math.max(currentMax, A[i]);
        }
    }
}
