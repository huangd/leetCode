package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huangd on 9/29/15.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return isValidRowsColumns(board) && isValidBlocks(board);
    }

    private boolean isValidRowsColumns(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            Set<Character> rowNumberSet = new HashSet<Character>();
            Set<Character> columnNumberSet = new HashSet<Character>();
            for (int j = 0; j < size; j++) {
                char rowNumber = board[i][j];
                if (rowNumber != '.' && rowNumberSet.contains(rowNumber)) {
                    return false;
                }
                rowNumberSet.add(rowNumber);
                char columnNumber = board[j][i];
                if (columnNumber != '.' && columnNumberSet.contains(columnNumber)) {
                    return false;
                }
                columnNumberSet.add(columnNumber);
            }
        }
        return true;
    }

    private boolean isValidBlocks(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i += 3) {
            for (int j = 0; j < size; j += 3) {
                Set<Character> blockNubmerSet = new HashSet<Character>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        char blockNumber = board[k][l];
                        if (blockNumber != '.' && blockNubmerSet.contains(blockNumber)) {
                            return false;
                        }
                        blockNubmerSet.add(blockNumber);
                    }
                }
            }
        }
        return true;
    }
}
