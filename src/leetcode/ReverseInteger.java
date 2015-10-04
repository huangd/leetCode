package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 8:19 PM
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean isPositive = x >= 0 ? true : false;
        String rXs = new StringBuilder(Math.abs(x) + "").reverse().toString();
        rXs = rXs.replace('0', ' ').trim().replace(' ', '0');
        rXs = rXs.equals("") ? "0" : rXs;
        try {
            return isPositive ? new Integer(rXs) : new Integer("-" + rXs);
        } catch (Exception e) {
            return 0;
        }
    }
}
