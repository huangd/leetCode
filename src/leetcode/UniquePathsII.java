package leetcode;

/**
 * User: huangd
 * Date: 3/2/13
 * Time: 12:05 PM
 */
public class UniquePathsII {

    private int[][] cache;
    private int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        //Pay attention to these special cases
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][column - 1] == 1) {
            return 0;
        }
        cache = new int[row][column];
        cache[0][0] = 1;
        this.obstacleGrid = obstacleGrid;
        return uniquePath(row - 1, column - 1);
    }

    private int uniquePath(int x, int y) {

        if (cache[x][y] != 0) {
            return cache[x][y];
        } else {
            int sum = 0;
            if (x - 1 >= 0 && obstacleGrid[x - 1][y] == 0) {
                sum += uniquePath(x - 1, y);
            }
            if (y - 1 >= 0 && obstacleGrid[x][y - 1] == 0) {
                sum += uniquePath(x, y - 1);
            }
            cache[x][y] = sum;
            return cache[x][y];
        }
    }
}
