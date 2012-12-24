package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 10:53 AM
 */
public class CombinationSum {

    private int[] candidates;
    private Map<Integer, ArrayList<ArrayList<Integer>>> cache;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.candidates = candidates;
        cache = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        return process(target);
    }

    private ArrayList<ArrayList<Integer>> process(int target) {

        ArrayList<ArrayList<Integer>> listListInteger = cache.get(target);
        if(listListInteger != null){
            return listListInteger;
        }else{
            listListInteger = new ArrayList<ArrayList<Integer>>();
        }

        if(target < 0){
        } else if(target == 0){
            listListInteger.add(new ArrayList<Integer>());
        } else{
            for(int candidate : candidates){
                ArrayList<ArrayList<Integer>> aListListInteger
                        = process(target-candidate);
                aListListInteger = addOne(aListListInteger, candidate);
                listListInteger.addAll(aListListInteger);
            }
        }
        listListInteger = clean(listListInteger, target);
        cache.put(target, listListInteger);
        return listListInteger;
    }

    private ArrayList<ArrayList<Integer>> clean(ArrayList<ArrayList<Integer>> listListInteger, int target){
        ArrayList<ArrayList<Integer>> cleanListListInteger
                = new ArrayList<ArrayList<Integer>>();

        for(ArrayList<Integer> listInteger : listListInteger){
            int sum = 0;
            for(Integer integer : listInteger){
                sum += integer;
            }
            if(sum == target){
                cleanListListInteger.add(listInteger);
            }
        }
        return cleanListListInteger;
    }

    private ArrayList<ArrayList<Integer>> addOne(ArrayList<ArrayList<Integer>> listListInteger,
                                                 int candidate){
        ArrayList<ArrayList<Integer>> newListListInteger = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> listInteger : listListInteger){
            int size = listInteger.size();
            if(listInteger.size() == 0
                    || listInteger.get(size-1) <= candidate){
                ArrayList<Integer> newListInteger = new ArrayList<Integer>(listInteger);
                newListInteger.add(candidate);
                newListListInteger.add(newListInteger);
            }
        }
        return newListListInteger;
    }
}
