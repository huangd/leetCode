package leetcode;

import java.util.Stack;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 5:03 PM
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return process(s);
    }

    private int process(String s) {
        for (int from = 0; from < s.length(); ++from) {
            for (int to = s.length(); to > from; --to) {
                if (isValid(s.substring(from, to))) {
                    return to - from;
                }
            }
        }
        return 0;
    }

    private boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
