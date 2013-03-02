package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 8:47 PM
 */
public class Anagrams {

    private HashMap<String, ArrayList<String>> map;

    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        map = new HashMap<String, ArrayList<String>>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(word);
            } else {
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(word);
                map.put(sorted, arrayList);
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            ArrayList<String> arrayList = entry.getValue();
            if (arrayList.size() > 1) {
                result.addAll(arrayList);
            }
        }
        return result;
    }
}
