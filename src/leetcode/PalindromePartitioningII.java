package leetcode;

/**
 * User: huangd
 * Date: 3/2/13
 * Time: 3:21 PM
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return palindromeCut(s);
    }

    private int palindromeCut(String s) {
        if (isPalindrome(s)) {
            return 0;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < s.length(); ++i) {
                min = Math.min(min, palindromeCut(s.substring(0, i)) + palindromeCut(s.substring(i)) + 1);
            }
            return min;
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
