package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangd on 10/3/15.
 */
public class isIsomorphicStings {

    Map<Character, Character> charMap = new HashMap<Character, Character>();
    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if (charMap.containsKey(sC) && charMap.get(sC) != tC || !charMap.containsKey(sC) && charMap.containsValue(tC)) {
                return false;
            }
            charMap.put(sC, tC);
        }
        return true;
    }
}
