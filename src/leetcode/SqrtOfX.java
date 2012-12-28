package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 9:39 PM
 */
public class SqrtOfX {
    //This is NOT an easy one. Int overflow needs to be considered!!!
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sqrt(x, 0, x);
    }

    private int sqrt(int x, int start, int end) {
        int mid = start + (end - start) / 2;
        if (isOverflow(mid)) {
            return sqrt(x, start, mid - 1);
        } else {
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                if (isOverflow(mid + 1) || Math.abs(mid * mid - x) < Math.abs((mid + 1) * (mid + 1) - x)) {
                    return mid;
                } else {
                    return sqrt(x, mid + 1, end);
                }
            } else {
                if (Math.abs(mid * mid - x) < Math.abs((mid - 1) * (mid - 1) - x)) {
                    return mid - 1;
                } else {
                    return sqrt(x, start, mid - 1);
                }
            }
        }
    }

    private boolean isOverflow(int x) {
        if (x == 0) {
            return false;
        }
        int x2 = x * x;
        if (x2 / x == x) {
            return false;
        } else {
            return true;
        }
    }
}
