package leetcode;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 9:23 PM
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
