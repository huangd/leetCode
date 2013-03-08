package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 4:30 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {

    private int[] charCount;

    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        charCount = new int[26];
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            char aChar = s.charAt(i);
            charCount[aChar - 'a']++;
            if (charCount[aChar - 'a'] == 1) {
                maxLength = Math.max(maxLength, i - startIndex + 1);
            } else {
                while (s.charAt(startIndex) != aChar) {
                    charCount[s.charAt(startIndex) - 'a']--;
                    startIndex++;
                }
                charCount[s.charAt(startIndex) - 'a']--;
                startIndex++;
            }
        }
        return maxLength;
    }
}
