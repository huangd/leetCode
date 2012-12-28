package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 9:39 PM
 */
public class SqrtOfX {
    //This is NOT an easy one. Int overflow needs to be considered!!!
    //Cast int to long makes it easier.
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sqrt((long) x, 0, x);
    }

    private int sqrt(long x, int start, int end) {
        int mid = start + (end - start) / 2;
        if ((long) mid * mid == x) {
            return mid;
        } else if ((long) mid * mid < x) {
            if (Math.abs((long) mid * mid - x) < Math.abs((long) (mid + 1) * (mid + 1) - x)) {
                return mid;
            } else {
                return sqrt(x, mid + 1, end);
            }
        } else {
            if (Math.abs((long) mid * mid - x) < Math.abs((long) (mid - 1) * (mid - 1) - x)) {
                return mid - 1;
            } else {
                return sqrt(x, start, mid - 1);
            }
        }
    }
}
