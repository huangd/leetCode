package leetcode;

/**
 * User: huangd
 * Date: 2/15/13
 * Time: 10:08 PM
 */
public class SearchA2DMatrix {

    private int row;
    private int column;
    private int[][] matrix;

    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        row = matrix.length;
        column = matrix[0].length;
        this.matrix = matrix;
        return binarySearch(0, row * column, target);
    }

    private boolean binarySearch(int from, int to, int target) {
        while (from < to) {
            int midIndex = (from + to) / 2;
            int midValue = getValue(midIndex);
            if (midValue == target) {
                return true;
            } else {
                if (midValue < target) {
                    from = midIndex + 1;
                } else {
                    to = midIndex;
                }
            }
        }
        return false;
    }

    private int getValue(int index) {
        int currentRow = index / column;
        int currentColumn = index % column;
        return matrix[currentRow][currentColumn];
    }
}
