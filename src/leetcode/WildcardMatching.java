package leetcode;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 10:38 PM
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0 || p.length() == 0) {
            if (s.length() == 0 && p.length() == 0) {
                return true;
            } else if (s.length() == 0 && p.length() != 0) {
                if (p.charAt(0) == '*') {
                    return isMatch(s, p.substring(1));
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            return isMatch(s, p.substring(1)) ||
                    isMatch(s.substring(1), p.substring(1)) ||
                    isMatch(s.substring(1), p);
        } else if (p.charAt(0) == s.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }
}
