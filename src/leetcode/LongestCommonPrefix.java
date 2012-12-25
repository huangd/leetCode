package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 2:51 PM
 */
public class LongestCommonPrefix {

    //Passed the small test. Time complexity is O(N). We could use the binary search to bring it down to O(logN)
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function

        String commonPrefix = "";
        if (strs.length == 0) {
            return commonPrefix;
        } else if (strs[0].length() == 0) {
            return commonPrefix;
        } else {

            for (int i = 0; i < strs[0].length(); ++i) {
                char thisChar = strs[0].charAt(i);
                for (String aString : strs) {
                    if (i > aString.length() - 1 || aString.charAt(i) != thisChar) {
                        return commonPrefix;
                    }
                }
                commonPrefix += thisChar;
            }
            return commonPrefix;
        }
    }
}
