package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 8:19 PM
 */
public class ReverseInteger {
    //1000 <=> 1
    //could be integer overflow
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isNegative = x >= 0 ? false : true;
        x = Math.abs(x);
        StringBuilder reverseInt = new StringBuilder();
        while (x > 0) {
            int mod = x % 10;
            x /= 10;
            if (mod == 0) {
                if (reverseInt.length() > 0) {
                    reverseInt.append(mod);
                }
            } else {
                reverseInt.append(mod);
            }
        }
        if (reverseInt.length() == 0) {
            reverseInt.append(0);
        }
        int result = Integer.parseInt(reverseInt.toString());
        return isNegative == true ? result * (-1) : result;
    }
}
