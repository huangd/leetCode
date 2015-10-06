package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangd on 10/6/15.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strParts = str.split(" ");
        char[] patternParts = pattern.toCharArray();
        if (strParts.length != patternParts.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < patternParts.length; i++) {
            if (!map.containsKey(patternParts[i]) && !map.containsValue(strParts[i])) {
                map.put(patternParts[i], strParts[i]);
                continue;
            }
            if (!strParts[i].equals(map.get(patternParts[i]))) {
                return false;
            }
        }
        return true;
    }
}
