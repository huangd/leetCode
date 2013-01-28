package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 10:53 AM
 */
public class CombinationSum {

    private Set<ArrayList<Integer>> resultListSet;
    private int target;
    private int[] candidates;

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resultListSet = new HashSet<ArrayList<Integer>>();
        this.target = target;
        this.candidates = candidates;

        int sum = 0;
        backtrack(new ArrayList<Integer>(), sum);
        ArrayList<ArrayList<Integer>> resultListList = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> result : resultListSet) {
            resultListList.add(result);
        }
        return resultListList;
    }

    private void backtrack(ArrayList<Integer> integerArrayList, int sum) {
        if (isSolution(sum)) {
            ArrayList<Integer> aResult = new ArrayList<Integer>(integerArrayList);
            Collections.sort(aResult);
            resultListSet.add(aResult);
        } else {
            ArrayList<Integer> candidateList = getCandidateList(sum);
            for (Integer integer : candidateList) {
                integerArrayList.add(integer);
                backtrack(integerArrayList, sum + integer);
                integerArrayList.remove(integerArrayList.size() - 1);
            }
        }
    }

    private ArrayList<Integer> getCandidateList(int sum) {
        ArrayList<Integer> candidateList = new ArrayList<Integer>();
        for (int i = 0; i < candidates.length; ++i) {
            if (sum + candidates[i] <= target) {
                candidateList.add(candidates[i]);
            }
        }
        return candidateList;
    }

    private boolean isSolution(int sum) {
        return sum == target;
    }
}
