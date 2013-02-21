package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 2/20/13
 * Time: 8:21 PM
 */
public class WordSearch {

    private int row;
    private int column;
    private boolean[][] isUsed;
    private char[][] board;
    private String word;
    private boolean isExist;

    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        row = board.length;
        column = board[0].length;
        isUsed = new boolean[row][column];
        this.board = board;
        this.word = word;
        isExist = false;
        backtrack(0, 0, 0);
        return isExist;
    }

    private void backtrack(int index, int x, int y) {
        if (index == word.length() || isExist) {
            isExist = true;
        } else {
            ArrayList<Point> candidates = findCandidates(index, x, y);
            for (Point point : candidates) {
                isUsed[point.row][point.column] = true;
                backtrack(index + 1, point.row, point.column);
                isUsed[point.row][point.column] = false;
            }
        }
    }

    private ArrayList<Point> findCandidates(int index, int x, int y) {
        ArrayList<Point> candidates = new ArrayList<Point>();
        if (index == 0) {
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < column; ++j) {
                    if (board[i][j] == word.charAt(index)) {
                        candidates.add(new Point(i, j));
                    }
                }
            }
        } else {
            if (x + 1 < row && board[x + 1][y] == word.charAt(index) && !isUsed[x + 1][y]) {
                candidates.add(new Point(x + 1, y));
            }
            if (x - 1 >= 0 && board[x - 1][y] == word.charAt(index) && !isUsed[x - 1][y]) {
                candidates.add(new Point(x - 1, y));
            }
            if (y + 1 < column && board[x][y + 1] == word.charAt(index) && !isUsed[x][y + 1]) {
                candidates.add(new Point(x, y + 1));
            }
            if (y - 1 >= 0 && board[x][y - 1] == word.charAt(index) && !isUsed[x][y - 1]) {
                candidates.add(new Point(x, y - 1));
            }
        }
        return candidates;
    }

    private class Point {
        private int row;
        private int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
