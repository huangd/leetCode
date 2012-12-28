package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 8:07 PM
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for (int i = matrix.length; i > 0; i -= 2) {
            rotate(matrix, i);
        }
    }

    private void rotate(int[][] matrix, int currentSize) {
        if (currentSize > 1) {
            int org = (matrix.length - currentSize) / 2;
            for (int i = 0; i < currentSize - 1; ++i) {
                int left = matrix[org][org + i];
                int top = matrix[org + i][org + currentSize - 1];
                int right = matrix[org + currentSize - 1][org + currentSize - 1 - i];
                int down = matrix[org + currentSize - 1 - i][org];
                matrix[org + i][org + currentSize - 1] = left;
                matrix[org + currentSize - 1][org + currentSize - 1 - i] = top;
                matrix[org + currentSize - 1 - i][org] = right;
                matrix[org][org + i] = down;
            }
        }
    }
}
