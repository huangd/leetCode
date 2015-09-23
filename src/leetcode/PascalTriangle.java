package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangd on 9/22/15.
 * Given numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if ((i - 1) < 0 || j - 1 < 0 || j > i - 1) {
                    row.add(1);
                } else {
                    List<Integer> preRow = result.get(i - 1);
                    int partLeft = preRow.get(j - 1);
                    int partRight = preRow.get(j);
                    row.add(partLeft + partRight);
                }
            }
            result.add(row);
        }
        return result;
    }
}
