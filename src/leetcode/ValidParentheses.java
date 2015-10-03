package leetcode;

import java.util.Stack;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 10:19 PM
 */
public class ValidParentheses {

    Stack<Character> stack = new Stack<Character>();

    public boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char topC = stack.pop();
            if (c == ')' && topC == '(' ||
                    c == ']' && topC == '[' ||
                    c == '}' && topC =='{') {
                continue;
            }

            return false;
        }
        return stack.isEmpty();
    }
}
