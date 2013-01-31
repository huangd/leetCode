package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 1/30/13
 * Time: 8:59 PM
 */
public class Combinations {

    private ArrayList<ArrayList<Integer>> resultList;
    private int n;
    private int k;

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resultList = new ArrayList<ArrayList<Integer>>();
        this.k = k;
        this.n = n;
        backtrack(new ArrayList<Integer>(), 0);
        return resultList;
    }

    private void backtrack(ArrayList<Integer> currentCombination, int lowEnd) {
        if (isSolution(currentCombination)) {
            ArrayList<Integer> result = new ArrayList<Integer>(currentCombination);
            resultList.add(result);
        } else {
            ArrayList<Integer> candidates = getCandidates(lowEnd);
            for (Integer candidate : candidates) {
                currentCombination.add(candidate);
                backtrack(currentCombination, candidate);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    private ArrayList<Integer> getCandidates(int lowEnd) {
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        for (int i = lowEnd + 1; i <= n; ++i) {
            candidates.add(i);
        }
        return candidates;
    }

    private boolean isSolution(ArrayList<Integer> currentCombination) {
        return currentCombination.size() == k;
    }
}
