package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 10:26 PM
 */
public class MinimumWindowSubstring {

    //Very good summary using two tables: hasFound, needToFind and a counter
    // http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
    private String min;
    private Map<Character, LinkedList<Integer>> charIndex;
    private Map<Character, Integer> charNumber;

    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        min = "";
        init(T);
        process(S, T);
        return min;
    }

    private void init(String T) {
        charIndex = new HashMap<Character, LinkedList<Integer>>();
        charNumber = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); ++i) {
            LinkedList<Integer> queue = new LinkedList<Integer>();
            charIndex.put(T.charAt(i), queue);

            Integer number = charNumber.get(T.charAt(i));
            if (number == null) {
                number = 0;
            }
            charNumber.put(T.charAt(i), number + 1);
        }
    }

    private void process(String S, String T) {
        for (int i = 0; i < S.length(); ++i) {
            if (T.contains(S.charAt(i) + "")) {
                LinkedList<Integer> queue = charIndex.get(S.charAt(i));
                queue.add(i);
                updateMinString(S);
            }
        }
    }

    private void updateMinString(String S) {
        if (isEnoughCount()) {
            int start = Integer.MAX_VALUE;
            int end = Integer.MIN_VALUE;
            Set<Character> characterSet = charIndex.keySet();
            for (Character character : characterSet) {
                for (int index : charIndex.get(character)) {
                    if (index > end) {
                        end = index;
                    }
                    if (index < start) {
                        start = index;
                    }
                }
            }
            if (min.length() == 0 || end - start + 1 < min.length()) {
                min = S.substring(start, end + 1);
            }
        }
    }

    private boolean isEnoughCount() {
        Set<Character> characterSet = charNumber.keySet();
        for (Character character : characterSet) {
            int number = charNumber.get(character);
            int count = charIndex.get(character).size();
            if (number > count) {
                return false;
            }
            while (number < count) {
                charIndex.get(character).poll();
                count = charIndex.get(character).size();
            }
        }
        return true;
    }
}
