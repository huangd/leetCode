package leetcode;

/**
 * User: huangd
 * Date: 3/24/13
 * Time: 9:43 AM
 */
public class ValidNumber {

    private String numberStart = "(\\d+\\.?\\d*)";
    private String dotStart = "(\\.\\d+)";
    private String eNotation = "([eE][+-]?\\d+)";
    private String matchPattern = "[+-]?(" + numberStart + "|" + dotStart + ")" + eNotation + "?";

    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return s.trim().matches(matchPattern);
    }
}
