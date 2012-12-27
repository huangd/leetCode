package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 10:39 PM
 */
public class NQueens {

    //TODO: there are bugs here.
    private ArrayList<String[]> result;

    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<String[]>();
        char[][] nn = new char[n][n];
        init(nn);
        process(nn, 0);
        return result;
    }

    private void process(char[][] nn, int n) {
        if (nn.length == 1) {
            if (isValid(nn, 0, 0)) {
                addAResult(nn);
            }
        } else {
            for (int i = 0; i < nn.length; ++i) {
                if (isValid(nn, n, i)) {
                    if (n == nn.length) {
                        addAResult(nn);
                    } else {
                        process(nn, n + 1);
                    }
                    nn[n][i] = '.';
                    continue;
                }
            }
        }
    }

    private void init(char[][] nn) {
        for (int i = 0; i < nn.length; ++i) {
            for (int j = 0; j < nn[0].length; ++j) {
                nn[i][j] = '.';
            }
        }
    }

    private void addAResult(char[][] nn) {
        String[] lines = new String[nn.length];
        for (int i = 0; i < nn.length; ++i) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < nn[0].length; ++j) {
                stringBuilder.append(nn[i][j]);
            }
            lines[i] = stringBuilder.toString();
        }
        result.add(lines);
    }

    private boolean isValid(char[][] nn, int x, int y) {
        if (isVerticalValid(nn, x, y) && isCrossValid(nn, x, y)) {
            nn[x][y] = 'Q';
            return true;
        } else {
            return false;
        }
    }

    private boolean isVerticalValid(char[][] nn, int x, int y) {
        for (int i = 0; i < y; ++i) {
            if (nn[x][i] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private boolean isCrossValid(char[][] nn, int x, int y) {
        for (int i = x, j = y; i < nn.length && j > 0; ++i, --j) {
            if (nn[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = x, j = y; i > 0 && j > 0; --i, --j) {
            if (nn[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
