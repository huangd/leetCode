package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 12:11 PM
 */
public class InterleavingString {
    //Passed a small test only
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return process(s1, s2, s3);
    }

    private boolean process(String a, String b, String c) {
        int aLength = a.length();
        int bLength = b.length();
        int cLength = c.length();

        if (aLength * bLength * cLength == 0) {
            if (aLength + bLength + cLength == 0) {
                return true;
            } else if (cLength != 0) {
                return (a.equals(c) || b.equals(c));
            } else {
                return false;
            }
        } else {
            boolean ac = false;
            if (a.charAt(aLength - 1) == c.charAt(cLength - 1)) {
                ac = process(a.substring(0, aLength - 1), b, c.substring(0, cLength - 1));
            }
            boolean bc = false;
            if (b.charAt(bLength - 1) == c.charAt(cLength - 1)) {
                bc = process(a, b.substring(0, bLength - 1), c.substring(0, cLength - 1));
            }
            return (ac || bc);
        }
    }
}
