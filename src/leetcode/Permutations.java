package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 4:47 PM
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> listListInteger = new ArrayList<ArrayList<Integer>>();
        if (num.length != 0) {
            listListInteger.add(new ArrayList<Integer>());
        }
        for (int anInt : num) {
            listListInteger = process(listListInteger, anInt);
        }
        return listListInteger;
    }

    private ArrayList<ArrayList<Integer>> process(ArrayList<ArrayList<Integer>> listListInteger, int newInt) {
        ArrayList<ArrayList<Integer>> newListListInteger
                = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> listInteger : listListInteger) {
            for (int i = 0; i <= listInteger.size(); ++i) {
                ArrayList<Integer> newListInteger = new ArrayList<Integer>(listInteger);
                newListInteger.add(i, newInt);
                newListListInteger.add(newListInteger);
            }
        }
        return newListListInteger;
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteII(int[] nums) {
        ArrayList<Integer> numsArray = new ArrayList<>();
        for (int num : nums) {
            numsArray.add(num);
        }
        backtrack(new ArrayList<>(), numsArray);
        return result;
    }

    void backtrack(ArrayList<ArrayList<Integer>> partialResult, ArrayList<Integer> nums) {
        if (nums.size() == 0) {
            partialResult.forEach(list -> result.add((ArrayList<Integer>) list.clone()));
            return;
        }
        if (partialResult.size() == 0) {
            partialResult.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.size(); i++) {
            int finalI = i;
            partialResult.forEach(intList -> intList.add(nums.get(finalI)));
            ArrayList<Integer> subNums = (ArrayList<Integer>)nums.clone();
            subNums.remove(i);
            backtrack(partialResult, subNums);
            partialResult.forEach(intList -> intList.remove(intList.size() - 1));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.print(new Permutations().permuteII(nums));
    }
}
