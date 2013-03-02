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
        if (s.length() == 0 || s == null) {
            return 0;
        }
        //Tow additional places
        int[] ways = new int[s.length() + 2];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != '0') {
                ways[i + 2] = ways[i + 1];
            }
            if (i > 0 && isCombinable(s.charAt(i - 1), s.charAt(i))) {
                ways[i + 2] += ways[i];
            }
        }
        return ways[s.length() + 1];
    }

    private boolean isCombinable(char a, char b) {
        int abInt = Integer.parseInt(a + "" + b);
        if (abInt >= 10 && abInt <= 26) {
            return true;
        } else {
            return false;
        }
    }
}
