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
        //return s.trim().matches(matchPattern);
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return isValid(s.substring(1, s.length()));
        } else {
            return isValid(s);
        }
    }

    public boolean isValid(String s) {
        boolean hasInteger = false;
        boolean hasDot = false;
        boolean hasDecimal = false;
        boolean hasPow = false;
        boolean hasSign = false;
        boolean hasExponent = false;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (!hasInteger) {
                    hasInteger = true;
                } else if (hasDot && !hasPow && !hasDecimal) {
                    hasDecimal = true;
                } else if (hasPow && !hasExponent) {
                    hasExponent = true;
                }
            } else if (c == '.') {
                if (!hasDot && !hasPow) {
                    hasDot = true;
                } else {
                    return false;
                }
            } else if (c == 'e') {
                if (hasInteger && !hasPow) {
                    hasPow = true;
                } else {
                    return false;
                }
            } else if (c == '+' || c == '-') {
                if (hasPow && !hasSign && !hasExponent) {
                    hasSign = true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if ((hasInteger || (hasDot && hasDecimal)) && (hasPow == hasExponent)) {
            return true;
        } else {
            return false;
        }
    }
}
