package leetcode;

import java.util.*;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 1:42 PM
 */
public class ThreeSum {

    private Map<String, Integer> sumMap;

    //This is a buggy solution
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Set<String> duplicateSet = new HashSet<String>();
        ArrayList<ArrayList<Integer>> listListInteger = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        initSumMap(num);
        for(String string : sumMap.keySet()){
            int twoSum = sumMap.get(string);
            String[] twoStrings = string.split(",");
            int firstIndex = Integer.parseInt(twoStrings[0]);
            int secondIndex = Integer.parseInt(twoStrings[1]);
            for(int thirdIndex=0; thirdIndex<num.length; ++thirdIndex){
                if(thirdIndex > secondIndex && num[thirdIndex]+twoSum == 0){
                    ArrayList<Integer> listInteger = new ArrayList<Integer>();
                    listInteger.add(num[firstIndex]);
                    listInteger.add(num[secondIndex]);
                    listInteger.add(num[thirdIndex]);
                    String content = num[firstIndex]+num[secondIndex]+num[thirdIndex]+"";
                    if(!duplicateSet.contains(content)){
                        duplicateSet.add(content);
                        listListInteger.add(listInteger);
                    }
                }
            }
        }
        return listListInteger;
    }

    private void initSumMap(int[] num){
        sumMap = new HashMap<String, Integer>();
        for(int i=0; i<num.length-1; ++i){
            for(int j=i+1; j<num.length;++j){
                sumMap.put(i+","+j, num[i]+num[j]);
            }
        }
    }
}
