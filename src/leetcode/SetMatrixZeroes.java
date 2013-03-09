package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 1:19 PM
 */
public class SetMatrixZeroes {

    private int[][] matrix;

    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.matrix = matrix;
        boolean isTopZero = isTopZero();
        boolean isLeftZero = isLeftZero();
        mapZeroToTopAndLeft();
        updateMap(isTopZero, isLeftZero);
    }

    private boolean isTopZero() {
        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[0][i] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isLeftZero() {
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                return true;
            }
        }
        return false;
    }

    private void mapZeroToTopAndLeft() {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
    }

    private void updateMap(boolean isTopZero, boolean isLeftZero) {
        for (int i = 1; i < matrix[0].length; ++i) {
            if (matrix[0][i] == 0) {
                fillColumnZero(i);
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                fillRowZero(i);
            }
        }
        if (isTopZero) {
            fillRowZero(0);
        }
        if (isLeftZero) {
            fillColumnZero(0);
        }
    }

    private void fillRowZero(int row) {
        for (int i = 0; i < matrix[0].length; ++i) {
            matrix[row][i] = 0;
        }
    }

    private void fillColumnZero(int column) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i][column] = 0;
        }
    }
}
