package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 4:30 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {

    private Map<Character, Integer> charIndexMap;

    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        charIndexMap = new HashMap<Character, Integer>();
        int maxLength = 0;
        int length = 0;
        for (int i = 0; i < s.length(); ++i) {
            Integer charIndex = charIndexMap.get(s.charAt(i));
            if (charIndex != null) {
                charIndexMap = updateCharIndexMap(charIndex);
                length = i - charIndex;
            } else {
                length += 1;
            }
            charIndexMap.put(s.charAt(i), i);
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    private Map<Character, Integer> updateCharIndexMap(int index) {
        Map<Character, Integer> updatedCharIndexMap = new HashMap<Character, Integer>();
        Set<Character> keySet = charIndexMap.keySet();
        for (Character character : keySet) {
            if (charIndexMap.get(character) > index) {
                updatedCharIndexMap.put(character, charIndexMap.get(character));
            }
        }
        return updatedCharIndexMap;
    }
}
