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

    List<List<Integer>> results = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        backtrack(new ArrayList<>(), target);
        return results;
    }

    void backtrack(ArrayList<Integer> resultCandidate, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            ArrayList<Integer> newResult = new ArrayList<Integer>(resultCandidate);
            results.add(newResult);
            return;
        }
        for (int candidate : candidates) {
            if (resultCandidate.size() > 0 && resultCandidate.get(resultCandidate.size() - 1) > candidate) continue;
            if (candidate <= remain) {
                resultCandidate.add(candidate);
                backtrack(resultCandidate, remain - candidate);
                resultCandidate.remove(resultCandidate.size() - 1);
            }
        }
    }
}
