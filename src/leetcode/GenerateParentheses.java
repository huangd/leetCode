package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 10:06 PM
 */
public class GenerateParentheses {

    private ArrayList<String> resultList;

    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resultList = new ArrayList<String>();
        process(n, n, "");
        return resultList;
    }

    private void process(int open, int close, String parentheses) {
        if (open == 0) {
            for (; close > 0; close--) {
                parentheses += ")";
            }
            resultList.add(parentheses);
        } else if (close > open) {
            process(open - 1, close, parentheses + "(");
            process(open, close - 1, parentheses + ")");
        } else {
            process(open - 1, close, parentheses + "(");
        }
    }
}
