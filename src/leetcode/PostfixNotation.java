package leetcode;

import java.util.List;
import java.util.Stack;

/**
 * User: huangd
 * Date: 4/2/13
 * Time: 7:40 PM
 */
public class PostfixNotation {

    public double getPostfixNotation(List<String> input) {
        Stack<Double> stack = new Stack<Double>();
        for (String aString : input) {
            if (isOperator(aString)) {
                if (stack.size() < 2) {
                    throw new RuntimeException("Invalid input");
                } else {
                    Double two = stack.pop();
                    Double one = stack.pop();
                    stack.push(calculate(one, two, aString));
                }
            } else {
                try {
                    Double aDouble = Double.parseDouble(aString);
                    stack.push(aDouble);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid input", e);
                }
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            throw new RuntimeException("Invalid input");
        }
    }

    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        } else {
            return false;
        }
    }

    private double calculate(Double one, Double two, String operator) {
        if (operator.equals("+")) {
            return one + two;
        } else if (operator.equals("-")) {
            return one - two;
        } else if (operator.equals("*")) {
            return one * two;
        } else if (operator.equals("/")) {
            if (two == 0) {
                throw new RuntimeException("Invalid input");
            } else {
                return one / two;
            }
        } else {
            throw new RuntimeException("Invalid input");
        }
    }
}
