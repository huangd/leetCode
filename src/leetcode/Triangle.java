package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 1/29/13
 * Time: 9:39 PM
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] minPath = new int[triangle.size()];
        minPath[0] = triangle.get(0).get(0);
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); ++i) {
            minPath[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                minPath[j] = Math.min(minPath[j], minPath[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minPath[0];
    }
}
