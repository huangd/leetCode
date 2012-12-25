package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 2:40 PM
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lastWordLength = 0;
        boolean isPreSpace = true;
        boolean isCurrentSpace;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                isCurrentSpace = true;
            } else {
                isCurrentSpace = false;
            }

            if (!isCurrentSpace) {
                if (isPreSpace) {
                    lastWordLength = 1;
                } else {
                    lastWordLength += 1;
                }
            }
            isPreSpace = isCurrentSpace;
        }
        return lastWordLength;
    }
}
