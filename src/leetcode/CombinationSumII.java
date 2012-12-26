package leetcode;

import java.util.*;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 11:18 AM
 */
public class CombinationSumII {

    //TODO: DP is not working here. because the domain set is too huge.
    private Map<String, ArrayList<ArrayList<Integer>>> cache;

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        cache = new HashMap<String, ArrayList<ArrayList<Integer>>>();
        Arrays.sort(candidates);
        return process(target, candidates);
    }

    private ArrayList<ArrayList<Integer>> process(int target, int[] candidates) {

        String key = target + ":" + Arrays.toString(candidates);
        ArrayList<ArrayList<Integer>> listListInteger = cache.get(key);
        if (listListInteger != null) {
            return listListInteger;
        } else {
            listListInteger = new ArrayList<ArrayList<Integer>>();
        }

        if (target < 0) {
        } else if (target == 0) {
            listListInteger.add(new ArrayList<Integer>());
        } else {
            for (int i = 0; i < candidates.length; ++i) {
                int candidate = candidates[i];
                ArrayList<ArrayList<Integer>> aListListInteger
                        = process(target - candidate, removeCandidate(candidates, i));
                aListListInteger = addOne(aListListInteger, candidate);
                listListInteger.addAll(aListListInteger);
            }
        }
        listListInteger = clean(listListInteger, target);
        cache.put(key, listListInteger);
        return listListInteger;
    }

    private ArrayList<ArrayList<Integer>> clean(ArrayList<ArrayList<Integer>> listListInteger, int target) {
        Set<ArrayList<Integer>> dedupSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> cleanListListInteger
                = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Integer> listInteger : listListInteger) {
            int sum = 0;
            for (Integer integer : listInteger) {
                sum += integer;
            }
            if (sum == target) {
                if (!dedupSet.contains(listInteger)) {
                    cleanListListInteger.add(listInteger);
                    dedupSet.add(listInteger);
                }
            }
        }
        return cleanListListInteger;
    }

    private ArrayList<ArrayList<Integer>> addOne(ArrayList<ArrayList<Integer>> listListInteger,
                                                 int candidate) {
        ArrayList<ArrayList<Integer>> newListListInteger = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> listInteger : listListInteger) {
            int size = listInteger.size();
            if (listInteger.size() == 0
                    || listInteger.get(size - 1) <= candidate) {
                ArrayList<Integer> newListInteger = new ArrayList<Integer>(listInteger);
                newListInteger.add(candidate);
                newListListInteger.add(newListInteger);
            }
        }
        return newListListInteger;
    }

    private int[] removeCandidate(int[] candidates, int index) {
        int[] newCandidates = new int[candidates.length - 1];
        for (int i = 0; i < candidates.length; ++i) {
            if (i < index) {
                newCandidates[i] = candidates[i];
            } else if (i > index) {
                newCandidates[i - 1] = candidates[i];
            }
        }
        return newCandidates;
    }
}
