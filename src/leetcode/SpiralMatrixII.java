package leetcode;

/**
 * User: huangd
 * Date: 2/16/13
 * Time: 4:17 PM
 */
public class SpiralMatrixII {

    private int[][] matrix;
    private int currentNumber;

    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        matrix = new int[n][n];
        currentNumber = 1;
        traverse(0, 0, n, n);
        return matrix;
    }

    public void traverse(int x, int y, int m, int n) {
        if (m > 0 && n > 0) {
            //top
            for (int i = y; i < n + y; ++i) {
                matrix[x][i] = currentNumber;
                currentNumber += 1;
            }
            //right
            for (int i = x + 1; i < m + x; ++i) {
                matrix[i][n - 1 + y] = currentNumber;
                currentNumber += 1;
            }
            //bottom, pay attention to corner case m > 1
            for (int i = n - 2 + y; i >= y && m > 1; --i) {
                matrix[m - 1 + x][i] = currentNumber;
                currentNumber += 1;
            }
            //left, pay attention to corner case n > 1
            for (int i = m - 2 + x; i > x && n > 1; --i) {
                matrix[i][y] = currentNumber;
                currentNumber += 1;
            }
            traverse(x + 1, y + 1, m - 2, n - 2);
        }
    }
}
