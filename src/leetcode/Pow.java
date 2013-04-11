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
        double result = powPositive(x, n);
        return isNegative ? 1 / result : result;
    }

    public double powPositive(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            if (n / 2 * 2 == n) {
                return powPositive(x, n / 2) * powPositive(x, n / 2);
            } else {
                return powPositive(x, n / 2) * powPositive(x, n / 2) * x;
            }
        }
    }
}
