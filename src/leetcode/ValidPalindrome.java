package leetcode;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 10:10 PM
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int[] chars = s.toLowerCase().chars()
                .map( c -> (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') ? c : 0)
                .filter( c -> c != 0 ).toArray();
        s = new String(chars, 0, chars.length);
        String rS = new StringBuilder(s).reverse().toString();
        return s.equals(rS);
    }
}
