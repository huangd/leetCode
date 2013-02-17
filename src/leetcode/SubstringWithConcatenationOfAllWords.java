package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * User: huangd
 * Date: 2/17/13
 * Time: 11:26 AM
 */
public class SubstringWithConcatenationOfAllWords {
    private ArrayList<Integer> result;
    private HashMap<String, Integer> lWordMap;

    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<Integer>();
        int lSize = L.length;
        int wordSize = L[0].length();
        init(L);
        for (int i = 0; i <= S.length() - wordSize * lSize; ++i) {
            HashMap<String, Integer> matchedWordMap = new HashMap<String, Integer>();
            int j = 0;
            for (; j < lSize; ++j) {
                String word = S.substring(i + wordSize * j, i + wordSize * j + wordSize);
                Integer count = lWordMap.get(word);
                if (count == null) {
                    break;
                } else {
                    Integer matchedCount = matchedWordMap.get(word);
                    if (matchedCount == null) {
                        matchedCount = 0;
                    }
                    matchedCount += 1;
                    matchedWordMap.put(word, matchedCount);
                    if (matchedCount > count) {
                        break;
                    }
                }
            }
            if (j == lSize) {
                result.add(i);
            }
        }
        return result;
    }

    private void init(String[] L) {
        lWordMap = new HashMap<String, Integer>();
        for (String word : L) {
            Integer count = lWordMap.get(word);
            if (count == null) {
                count = 0;
            }
            count += 1;
            lWordMap.put(word, count);
        }
    }
}
