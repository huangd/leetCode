package leetcode;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 10:10 PM
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = trim(s);
        String r = reverse(s);
        return s.equals(r);
    }

    private String trim(String s) {
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
