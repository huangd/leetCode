package leetcode;

/**
 * User: huangd
 * Date: 1/31/13
 * Time: 7:42 PM
 */
public class DecodeWays {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0) {
            return 0;
        }
        int[] ways = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            if (isValid(s.charAt(i))) {
                if (i > 0) {
                    if (isCombinable(s.charAt(i - 1), s.charAt(i))) {
                        if (i > 1) {
                            ways[i] = ways[i - 1] + ways[i - 2];
                        } else {
                            ways[i] = 2;
                        }
                    } else {
                        ways[i] = ways[i - 1];
                    }
                } else {
                    ways[i] = 1;
                }
            } else {
                if (i == 0) {
                    return 0;
                } else {
                    if (isCombinable(s.charAt(i - 1), s.charAt(i))) {
                        if (i > 1) {
                            ways[i] = ways[i - 2];
                        } else {
                            ways[i] = 1;
                        }
                    } else {
                        return 0;
                    }
                }
            }
        }
        return ways[s.length() - 1];
    }

    private boolean isCombinable(char a, char b) {
        int aInt = Integer.parseInt(a + "");
        int bInt = Integer.parseInt(b + "");

        if (aInt == 1) {
            return true;
        } else if (aInt == 2) {
            if (bInt >= 0 && bInt <= 6) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isValid(char a) {
        int aInt = Integer.parseInt(a + "");
        if (aInt > 0 && aInt <= 9) {
            return true;
        } else {
            return false;
        }
    }
}
