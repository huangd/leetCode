package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 9:39 PM
 */
public class SqrtOfX {
    //This is NOT an easy one. Int overflow needs to be considered!!!
    //Cast int to double makes it easier.
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sqrt((double) x, 0, x);
    }

    private int sqrt(double x, int start, int end) {
        int mid = start + (end - start) / 2;
        if ((double) mid * mid == x) {
            return mid;
        } else if ((double) mid * mid < x) {
            if (Math.abs((double) mid * mid - x) < Math.abs((double) (mid + 1) * (mid + 1) - x)) {
                return mid;
            } else {
                return sqrt(x, mid + 1, end);
            }
        } else {
            if (Math.abs((double) mid * mid - x) < Math.abs((double) (mid - 1) * (mid - 1) - x)) {
                return mid - 1;
            } else {
                return sqrt(x, start, mid - 1);
            }
        }
    }
}
