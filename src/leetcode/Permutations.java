package leetcode;

import java.util.ArrayList;

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
}
