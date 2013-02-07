package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 10:39 PM
 */
public class NQueens {

    private ArrayList<String[]> results;

    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        results = new ArrayList<String[]>();
        backtrack(new int[n], 0);
        return results;
    }

    private void backtrack(int[] positions, int current) {
        if (isSolution(positions, current)) {
            updateResult(positions);
        } else {
            int[] candidates = getCandidates(positions, current);
            for (int i = 0; i < candidates.length; ++i) {
                positions[current] = candidates[i];
                backtrack(positions, current + 1);
            }
        }
    }

    private boolean isSolution(int[] positions, int current) {
        return positions.length == current;
    }

    private void updateResult(int[] positions) {
        String[] oneResult = new String[positions.length];
        for (int i = 0; i < oneResult.length; ++i) {
            String aRow = "";
            for (int j = 0; j < positions.length; ++j) {
                if (positions[i] == j) {
                    aRow += "Q";
                } else {
                    aRow += ".";
                }
            }
            oneResult[i] = aRow;
        }
        results.add(oneResult);
    }

    private int[] getCandidates(int[] positions, int current) {
        ArrayList<Integer> candidateList = new ArrayList<Integer>();
        for (int i = 0; i < positions.length; ++i) {
            boolean isCandidate = true;
            for (int j = 0; j < current; ++j) {
                boolean isVertical = positions[j] == i;
                boolean forwardCross = (j - positions[j]) == (current - i);
                boolean backwardCross = (j - (positions.length - positions[j] - 1)) == (current - (positions.length - i - 1));
                if (isVertical || forwardCross || backwardCross) {
                    isCandidate = false;
                    break;
                }
            }
            if (isCandidate) {
                candidateList.add(i);
            }
        }
        int[] candidates = new int[candidateList.size()];
        for (int i = 0; i < candidates.length; ++i) {
            candidates[i] = candidateList.get(i);
        }
        return candidates;
    }
}
