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
    private int totalNumber;
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        init(S, T);
        process(T, 0, -1);
        return totalNumber;
    }

    private void process(String t, int tIndex, int lastPosition){
        if(tIndex >= t.length()){
            totalNumber++;
            return;
        }
        char aChar = t.charAt(tIndex);
        ArrayList<Integer> arrayList = indexMap.get(aChar);
        for(int position : arrayList){
            if(position > lastPosition){
                process(t, tIndex+1, position);
            }
        }
    }

    private void init(String s, String t){
        indexMap = new HashMap<Character, ArrayList<Integer>>();
        for(int i=0; i<t.length(); ++i){
            char aChar = t.charAt(i);
            ArrayList<Integer> indexList = getIndexList(s, aChar);
            indexMap.put(aChar, indexList);
        }
        totalNumber = 0;
    }

    private ArrayList<Integer> getIndexList(String s, char c){
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        int index = -1;
        while( (index = s.indexOf(c, index+1)) != -1){
            indexList.add(index);
        }
        return indexList;
    }
}
