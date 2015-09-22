package leetcode;

/**
 * Created by huangd on 9/21/15.
 * Given an integer, write a function to determine if it is a power of two
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n > 0 && n == n / 2 * 2) {
            return isPowerOfTwo(n / 2);
        }
        return false;
    }
}
