package leetcode;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 7:35 PM
 */
public class DistinctSubsequences {
    private String S;
    private String T;

    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.S = S;
        this.T = T;
        return recursive(S.length() - 1, T.length() - 1);
    }

    private int recursive(int sIndex, int tIndex) {
        if (sIndex == -1 || tIndex == -1) {
            if (tIndex == -1) {
                return 1;
            } else {
                return 0;
            }
        }
        if (S.charAt(sIndex) != T.charAt(tIndex)) {
            return recursive(sIndex - 1, tIndex);
        } else {
            return recursive(sIndex - 1, tIndex - 1) + recursive(sIndex - 1, tIndex);
        }
    }
}
