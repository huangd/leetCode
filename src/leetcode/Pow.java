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
        if (n == 0) {
            return 1;
        }
        boolean isNegative = n >= 0 ? false : true;
        n = Math.abs(n);
        double result = 1;
        double currentPow = x;
        while (n != 0) {
            if (n % 2 == 1) {
                result *= currentPow;
            }
            currentPow *= currentPow;
            n /= 2;
        }
        return isNegative ? 1 / result : result;
    }
}
