package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 7:35 PM
 */
public class DistinctSubsequences {

    private Map<Character, ArrayList<Integer>> indexMap;
    private String target;
    private Map<String, Integer> cache;

    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        init(S, T);
        return process(0, -1);
    }

    private void init(String s, String t) {
        target = t;
        cache = new HashMap<String, Integer>();
        indexMap = new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < t.length(); ++i) {
            char aChar = t.charAt(i);
            ArrayList<Integer> indexList = getIndexList(s, aChar);
            indexMap.put(aChar, indexList);
        }
    }

    private int process(int tIndex, int lastPosition) {
        Integer cacheNumber = cache.get(tIndex + "," + lastPosition);
        if (cacheNumber != null) {
            return cacheNumber;
        }
        if (tIndex >= target.length()) {
            return 1;
        }

        int number = 0;
        char aChar = target.charAt(tIndex);
        ArrayList<Integer> arrayList = indexMap.get(aChar);

        for (int position : arrayList) {
            if (position > lastPosition) {
                number += process(tIndex + 1, position);
            }
        }
        cache.put(tIndex + "," + lastPosition, number);
        return number;
    }

    private ArrayList<Integer> getIndexList(String s, char c) {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        int index = -1;
        while ((index = s.indexOf(c, index + 1)) != -1) {
            indexList.add(index);
        }
        return indexList;
    }
}
