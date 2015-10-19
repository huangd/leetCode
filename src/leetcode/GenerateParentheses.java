package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 10:06 PM
 */
public class GenerateParentheses {

    List<String> pList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n, "");
        return pList;
    }

    void backtrack(int start, int close, String partialSolution) {
        if (start == 0 && close == 0) pList.add(partialSolution);
        if (start > 0) backtrack(start - 1, close, partialSolution + "(");
        if (start < close) backtrack(start, close - 1, partialSolution + ")");
    }
}