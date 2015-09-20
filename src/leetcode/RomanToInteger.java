package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangd on 9/19/15.
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> letterToNumberMap = new HashMap<Character, Integer>();
        letterToNumberMap.put('I', 1);
        letterToNumberMap.put('V', 5);
        letterToNumberMap.put('X', 10);
        letterToNumberMap.put('L', 50);
        letterToNumberMap.put('C', 100);
        letterToNumberMap.put('D', 500);
        letterToNumberMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // Only one letter left
            if (i == s.length() - 1) {
                result += letterToNumberMap.get(s.charAt(i));
                continue;
            }
            // There are more than one letter left
            // Special case, need to do subtract
            char nextChar = s.charAt(i + 1);
            if ((currentChar == 'I' && (nextChar == 'V' || nextChar == 'X')) ||
                    (currentChar == 'X' && (nextChar == 'L' || nextChar == 'C')) ||
                    (currentChar == 'C' && (nextChar == 'D' || nextChar == 'M')))  {
                result += letterToNumberMap.get(nextChar) - letterToNumberMap.get(currentChar);
                i++;
                continue;
            }
            // Regular case
            result += letterToNumberMap.get(currentChar);
        }
        return result;
    }
}
