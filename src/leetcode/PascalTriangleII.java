package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangd on 9/23/15.
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        List<Integer> row = new ArrayList<Integer>();
        List<Integer> preRow = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < i + 1; j++) {
                if ((i - 1) < 0 || j - 1 < 0 || j > i - 1) {
                    row.add(j, 1);
                } else {
                    row.add(j, preRow.get(j - 1) + preRow.get(j));
                }
            }
            List<Integer> tmp = row;
            row = preRow;
            preRow = tmp;
        }
        return preRow;
    }

    public static void main(String[] args) {
        // TODO: Figure out why it is returning [1, 2, 1, 1] instead of [1, 2, 1]
        System.out.println(new PascalTriangleII().getRow(2));
    }
}
