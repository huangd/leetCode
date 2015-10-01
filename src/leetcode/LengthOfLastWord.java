package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 2:40 PM
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] parts = s.trim().split(" ");
        return parts[parts.length - 1].length();
    }
}
