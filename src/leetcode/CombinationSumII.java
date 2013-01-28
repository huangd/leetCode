package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 11:18 AM
 */
public class CombinationSumII {

    private Set<ArrayList<Integer>> resultListSet;
    private int target;
    private int[] candidates;

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resultListSet = new HashSet<ArrayList<Integer>>();
        this.target = target;
        this.candidates = candidates;

        int sum = 0;
        boolean inCandidates[] = new boolean[candidates.length];
        backtrack(new ArrayList<Integer>(), sum, inCandidates);
        ArrayList<ArrayList<Integer>> resultListList = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> result : resultListSet) {
            resultListList.add(result);
        }
        return resultListList;
    }

    private void backtrack(ArrayList<Integer> integerArrayList, int sum, boolean[] inCandidates) {
        if (isSolution(sum)) {
            ArrayList<Integer> aResult = new ArrayList<Integer>(integerArrayList);
            Collections.sort(aResult);
            resultListSet.add(aResult);
        } else {
            ArrayList<Integer> candidateListIndex = getCandidateListIndex(sum, inCandidates);
            for (Integer index : candidateListIndex) {
                integerArrayList.add(candidates[index]);
                inCandidates[index] = true;
                backtrack(integerArrayList, sum + candidates[index], inCandidates);
                integerArrayList.remove(integerArrayList.size() - 1);
                inCandidates[index] = false;
            }
        }
    }

    private ArrayList<Integer> getCandidateListIndex(int sum, boolean[] inCandidates) {
        ArrayList<Integer> candidateListIndex = new ArrayList<Integer>();
        for (int i = 0; i < candidates.length; ++i) {
            if (sum + candidates[i] <= target && inCandidates[i] == false) {
                candidateListIndex.add(i);
            }
        }
        return candidateListIndex;
    }

    private boolean isSolution(int sum) {
        return sum == target;
    }
}
