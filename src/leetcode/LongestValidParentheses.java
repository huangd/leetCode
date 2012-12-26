package leetcode;

import java.util.Stack;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 5:03 PM
 */
public class LongestValidParentheses {

    private Stack<Integer> stack;
    private int longest;
    private int current;

    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        stack = new Stack<Integer>();
        longest = 0;
        current = 0;
        process(s);
        return longest;
    }

    private void process(String s) {
        for (int i = 0; i < s.length(); ++i) {
            processChar(s.charAt(i));
        }
    }

    private void processChar(char c) {
        if (c == '(') {
            stack.push(current + 2);
            current = 0;
        } else {
            if (stack.isEmpty()) {
                updateLongest();
                current = 0;
            } else {
                current += stack.pop();
                updateLongest();
            }
        }
    }

    private void updateLongest() {
        if (current > longest) {
            longest = current;
        }
    }
}
