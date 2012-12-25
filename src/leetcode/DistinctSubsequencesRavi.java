package leetcode;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 7:35 PM
 */
public class DistinctSubsequencesRavi {

    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recNumDistinct(S, T);
    }

    private int recNumDistinct(String S, String T) {
        if (S.length() >= 0 && T.length() == 0) {
            return 1;
        } else if (S.length() < T.length() || T.length() == 0) {
            return 0;
        } else {
            if (S.charAt(S.length() - 1) == T.charAt(T.length() - 1)) {
                return recNumDistinct(S.substring(0, S.length() - 1), T.substring(0, T.length() - 1)) +
                        recNumDistinct(S.substring(0, S.length() - 1), T.substring(0, T.length()));
            } else {
                return recNumDistinct(S.substring(0, S.length() - 1), T.substring(0, T.length()));
            }
        }
    }
}
