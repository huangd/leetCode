package leetcode;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 8:14 PM
 */
public class MinimumPathSum {

    private int[][] cache;
    private int[][] grid;

    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = grid.length;
        int column = grid[0].length;
        this.grid = grid;
        cache = new int[row][column];
        init();
        return minSum(row - 1, column - 1);
    }

    private int minSum(int x, int y) {
        if (cache[x][y] == -1) {
            int val = grid[x][y];
            int left = -1;
            if (x - 1 >= 0) {
                left = minSum(x - 1, y);
            }
            int down = -1;
            if (y - 1 >= 0) {
                down = minSum(x, y - 1);
            }
            if (left != -1 && down != -1) {
                cache[x][y] = val + Math.min(left, down);
            } else if (left == -1 && down == -1) {
                cache[x][y] = val;
            } else {
                cache[x][y] = val + Math.max(left, down);
            }
        }
        return cache[x][y];
    }

    private void init() {
        for (int i = 0; i < cache.length; ++i) {
            for (int j = 0; j < cache[0].length; ++j) {
                cache[i][j] = -1;
            }
        }
    }
}
