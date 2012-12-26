package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 4:13 PM
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return longestPalindrome(s, reverse(s));
    }

    private String longestPalindrome(String s, String r) {
        if (s.equals(r)) {
            return s;
        } else {
            String firstDelete = longestPalindrome(s.substring(1, s.length()), r.substring(0, r.length() - 1));
            String lastDelete = longestPalindrome(s.substring(0, s.length() - 1), r.substring(1, r.length()));
            if (firstDelete.length() > lastDelete.length()) {
                return firstDelete;
            } else {
                return lastDelete;
            }
        }
    }

    private String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
