package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 2:51 PM
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length == 0) {
            return prefix;
        }
        for (int i = 0; ; i ++) {
            char letter = ' ';
            for (String str : strs) {
                if (str.length() > i && (str.charAt(i) == letter || letter == ' ')) {
                    letter = str.charAt(i);
                } else {
                    return prefix;
                }
            }
            prefix += letter;
        }
    }
}
