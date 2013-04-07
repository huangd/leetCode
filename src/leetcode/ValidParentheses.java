package leetcode;

import java.util.Stack;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 10:19 PM
 */
public class ValidParentheses {

    private Stack<String> stack;

    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        stack = new Stack<String>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c + "");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    String top = stack.pop();
                    if (!isMatch(top.charAt(0), c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char a, char b) {
        if (a == '(' && b == ')' ||
                a == '{' && b == '}' ||
                a == '[' && b == ']') {
            return true;
        } else {
            return false;
        }
    }
}
