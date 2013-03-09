package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 10:02 AM
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int indexS, String p, int indexP) {
        if (p.length() == indexP) {
            return s.length() == indexS;
        }

        if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
            boolean noShow = isMatch(s, indexS, p, indexP + 2);
            if (indexS == s.length()) {
                return noShow;
            } else {
                if (p.charAt(indexP) == '.' || s.charAt(indexS) == p.charAt(indexP)) {
                    return isMatch(s, indexS + 1, p, indexP + 2) || isMatch(s, indexS + 1, p, indexP) || noShow;
                } else {
                    return noShow;
                }
            }
        } else {
            if (indexS < s.length()) {
                if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.') {
                    return isMatch(s, indexS + 1, p, indexP + 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
