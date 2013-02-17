package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 2/16/13
 * Time: 3:23 PM
 */
public class SpiralMatrix {

    private ArrayList<Integer> result;
    private int[][] matrix;

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<Integer>();
        this.matrix = matrix;
        if (matrix != null && matrix.length > 0) {
            traverse(0, 0, matrix.length, matrix[0].length);
        }
        return result;
    }

    public void traverse(int x, int y, int m, int n) {
        if (m > 0 && n > 0) {
            //top
            for (int i = y; i < n + y; ++i) {
                result.add(matrix[x][i]);
            }
            //right
            for (int i = x + 1; i < m + x; ++i) {
                result.add(matrix[i][n - 1 + y]);
            }
            //bottom, pay attention to corner case m > 1
            for (int i = n - 2 + y; i >= y && m > 1; --i) {
                result.add(matrix[m - 1 + x][i]);
            }
            //left, pay attention to corner case n > 1
            for (int i = m - 2 + x; i > x && n > 1; --i) {
                result.add(matrix[i][y]);
            }
            traverse(x + 1, y + 1, m - 2, n - 2);
        }
    }
}
