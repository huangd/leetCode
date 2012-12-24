package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 10:31 AM
 */
public class EditDistance {

    private Map<String, Integer> cache;

    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        cache = new HashMap<String, Integer>();
        return process(word1, word2);
    }

    private int process(String from, String to) {

        if (from.length() == 0 || to.length() == 0) {
            return Math.max(from.length(), to.length());
        }

        Integer number = cache.get(from.length() + "," + to.length());
        if (number != null) {
            return number;
        } else {
            int delete = process(from.substring(0, from.length() - 1), to) + 1;
            int insert = process(from, to.substring(0, to.length() - 1)) + 1;
            int replace = process(from.substring(0, from.length() - 1), to.substring(0, to.length() - 1));
            if (from.charAt(from.length() - 1) != to.charAt(to.length() - 1)) {
                replace += 1;
            }

            number = threeMin(delete, insert, replace);
            cache.put(from.length() + "," + to.length(), number);
            return number;
        }
    }

    private int threeMin(int a, int b, int c) {
        int tmp = Math.min(a, b);
        return Math.min(tmp, c);
    }
}
