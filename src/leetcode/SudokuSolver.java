package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * User: huangd
 * Date: 2/17/13
 * Time: 9:29 PM
 */
public class SudokuSolver {

    private boolean isFinish;

    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        isFinish = false;
        backtrack(board);
    }

    public void backtrack(char[][] board) {
        if (isSolution(board)) {
            isFinish = true;
        } else {
            Point blankPoint = getNextBlankPoint(board);
            Set<Integer> candidates = getCandidates(board, blankPoint);
            for (Integer anInt : candidates) {
                board[blankPoint.row][blankPoint.column] = (anInt + "").charAt(0);
                backtrack(board);
                if (isFinish) {
                    return;
                } else {
                    board[blankPoint.row][blankPoint.column] = '.';
                }
            }
        }
    }

    private Set<Integer> getCandidates(char[][] board, Point point) {
        int row = point.row;
        int column = point.column;
        Set<Integer> rowCandidates = getRowCandidates(board, row);
        Set<Integer> columnCandidates = getColumnCandidates(board, column);
        Set<Integer> squareCandidates = getSquareCandidates(board, row, column);
        squareCandidates.retainAll(rowCandidates);
        squareCandidates.retainAll(columnCandidates);
        return squareCandidates;
    }

    private Set<Integer> getRowCandidates(char[][] board, int row) {
        Set<Integer> candidates = new HashSet<Integer>();
        for (int i = 1; i < 10; ++i) {
            candidates.add(i);
        }
        for (int i = 0; i < board[0].length; ++i) {
            if (board[row][i] != '.') {
                Integer anInt = Integer.parseInt(board[row][i] + "");
                candidates.remove(anInt);
            }
        }
        return candidates;
    }

    private Set<Integer> getColumnCandidates(char[][] board, int column) {
        Set<Integer> candidates = new HashSet<Integer>();
        for (int i = 1; i < 10; ++i) {
            candidates.add(i);
        }
        for (int i = 0; i < board.length; ++i) {
            if (board[i][column] != '.') {
                Integer anInt = Integer.parseInt(board[i][column] + "");
                candidates.remove(anInt);
            }
        }
        return candidates;
    }

    private Set<Integer> getSquareCandidates(char[][] board, int row, int column) {
        Set<Integer> candidates = new HashSet<Integer>();
        for (int i = 1; i < 10; ++i) {
            candidates.add(i);
        }
        int startRow = row / 3 * 3;
        int startColumn = column / 3 * 3;
        for (int i = startRow; i < startRow + 3; ++i) {
            for (int j = startColumn; j < startColumn + 3; ++j) {
                if (board[i][j] != '.') {
                    Integer anInt = Integer.parseInt(board[i][j] + "");
                    candidates.remove(anInt);
                }
            }
        }
        return candidates;
    }

    private boolean isSolution(char[][] board) {
        if (getNextBlankPoint(board) == null) {
            return true;
        } else {
            return false;
        }
    }

    private Point getNextBlankPoint(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (board[i][j] == '.') {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    class Point {
        int row;
        int column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
