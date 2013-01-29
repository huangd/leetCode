package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 1:42 PM
 */
public class ThreeSum {

    private Set<ArrayList<Integer>> resultSet;
    private int[] num;

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        resultSet = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        this.num = num;
        process();
        return setToArray(resultSet);
    }

    private void process() {
        for (int i = 0; i < num.length; ++i) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                if (num[i] + num[j] + num[k] < 0) {
                    j++;
                } else if (num[i] + num[j] + num[k] > 0) {
                    k--;
                } else {
                    ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
                    integerArrayList.add(num[i]);
                    integerArrayList.add(num[j]);
                    integerArrayList.add(num[k]);
                    resultSet.add(integerArrayList);
                    j++;
                    k--;
                }
            }
        }
    }

    private ArrayList<ArrayList<Integer>> setToArray(Set<ArrayList<Integer>> resultSet) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> integerArrayList : resultSet) {
            resultList.add(integerArrayList);
        }
        return resultList;
    }
}
