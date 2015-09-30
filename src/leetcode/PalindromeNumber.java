package leetcode;

/**
 * Created by huangd on 9/29/15.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String xStr = new Integer(x).toString();
        for (int i = 0, j = xStr.length() - 1; i < j; i++, j--) {
            if (xStr.charAt(i) != xStr.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
