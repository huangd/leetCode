package leetcode;

/**
 * User: huangd
 * Date: 2/15/13
 * Time: 10:08 PM
 */
public class SearchA2DMatrix {

    private int[][] matrix;

    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.matrix = matrix;
        int row = binarySearchRow(0, matrix.length, target);
        return binarySearchColumn(0, matrix[0].length, row, target);
    }

    private int binarySearchRow(int from, int to, int target) {
        if (from < to) {
            int midIndex = (from + to) / 2;
            int midValue = matrix[midIndex][0];
            if (midValue == target) {
                return midIndex;
            } else {
                if (midValue < target) {
                    return binarySearchRow(midIndex + 1, to, target);
                } else {
                    return binarySearchRow(from, midIndex, target);
                }
            }
        } else {
            return from == 0 ? 0 : from - 1;
        }
    }

    private boolean binarySearchColumn(int from, int to, int row, int target) {
        if (from < to) {
            int midIndex = (from + to) / 2;
            int midValue = matrix[row][midIndex];
            if (midValue == target) {
                return true;
            } else {
                if (midValue < target) {
                    return binarySearchColumn(midIndex + 1, to, row, target);
                } else {
                    return binarySearchColumn(from, midIndex, row, target);
                }
            }
        } else {
            return false;
        }
    }
}
