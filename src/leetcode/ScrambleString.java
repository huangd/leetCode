package leetcode;

/**
 * User: huangd
 * Date: 2/15/13
 * Time: 7:20 PM
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValid(s1, s2);
    }

    public boolean isValid(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        } else {
            for (int i = 1; i <= s1.length() / 2; ++i) {
                String s1FrontI = s1.substring(0, i);
                String s2FrontI = s2.substring(0, i);
                String s1FrontRest = s1.substring(i);
                String s2FrontRest = s2.substring(i);
                String s1EndI = s1.substring(s1.length() - i);
                String s2EndI = s2.substring(s2.length() - i);
                String s1EndRest = s1.substring(0, s1.length() - i);
                String s2EndRest = s2.substring(0, s2.length() - i);
                if (isValid(s1FrontI, s2FrontI) && isValid(s1FrontRest, s2FrontRest)) {
                    return true;
                }
                if (isValid(s1FrontI, s2EndI) && isValid(s1FrontRest, s2EndRest)) {
                    return true;
                }
                if (isValid(s1EndI, s2FrontI) && isValid(s1EndRest, s2FrontRest)) {
                    return true;
                }
                if (isValid(s1EndI, s2EndI) && isValid(s1EndRest, s2EndRest)) {
                    return true;
                }
            }
            return false;
        }
    }
}
