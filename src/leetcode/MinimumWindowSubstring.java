package leetcode;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 10:26 PM
 */
public class MinimumWindowSubstring {

    //Very good summary using two tables: hasFound, needToFind and a counter
    // http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
    private int count;
    private int[] hasFound;
    private int[] needToFind;

    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        init(T);
        int min = Integer.MAX_VALUE;
        String minString = "";
        for (int start = 0, end = 0; end < S.length(); ++end) {
            char c = S.charAt(end);
            if (needToFind[c] == 0) {
                continue;
            } else {
                hasFound[c]++;
                if (hasFound[c] <= needToFind[c]) {
                    count++;
                }
                if (count == T.length()) {
                    while (needToFind[S.charAt(start)] == 0 || needToFind[S.charAt(start)] < hasFound[S.charAt(start)]) {
                        if (needToFind[S.charAt(start)] < hasFound[S.charAt(start)]) {
                            --hasFound[S.charAt(start)];
                        }
                        ++start;
                    }
                    int current = end - start + 1;
                    if (current < min) {
                        minString = S.substring(start, end + 1);
                        min = current;
                    }
                }
            }
        }
        return minString;
    }

    private void init(String T) {
        count = 0;
        hasFound = new int[256];
        needToFind = new int[256];
        for (char c : T.toCharArray()) {
            needToFind[c]++;
        }
    }
}
