package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 11:21 AM
 */
public class Pow {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isNegative = n >= 0 ? false : true;
        n = Math.abs(n);
        double result = 1;
        for (int i = 0; i < n; ++i) {
            result *= x;
        }
        return isNegative ? 1 / result : result;
    }
}
