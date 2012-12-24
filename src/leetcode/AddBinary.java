package leetcode;

import java.util.Stack;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 12:19 AM
 */
public class AddBinary {

    //Should pay attention to carryOver
    private Stack<Integer> aStack;
    private Stack<Integer> bStack;
    private Stack<Integer> sumStack;
    private int carryOver;

    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        init(a, b);
        while (!aStack.isEmpty() && !bStack.isEmpty()) {
            int aInt = aStack.pop();
            int bInt = bStack.pop();
            int sum = aInt + bInt + carryOver;
            pushToStack(sum, sumStack);
        }
        if (!aStack.isEmpty()) {
            pushRestStack(aStack, sumStack);
        }
        if (!bStack.isEmpty()) {
            pushRestStack(bStack, sumStack);
        }
        catchCarryOver();
        StringBuilder stringBuilder = new StringBuilder();
        while (!sumStack.isEmpty()) {
            stringBuilder.append(sumStack.pop());
        }
        return stringBuilder.toString();
    }

    private void pushToStack(int sum, Stack<Integer> stack) {
        if (sum == 3) {
            stack.push(1);
            carryOver = 1;
        } else if (sum == 2) {
            stack.push(0);
            carryOver = 1;
        } else {//sum == 0 || sum == 1
            stack.push(sum);
            carryOver = 0;
        }
    }

    private void catchCarryOver() {
        if (carryOver == 1) {
            sumStack.push(carryOver);
        }
    }

    private void pushRestStack(Stack<Integer> from, Stack<Integer> to) {
        while (!from.isEmpty()) {
            int fromInt = from.pop();
            int sum = fromInt + carryOver;
            pushToStack(sum, to);
        }
    }

    private void init(String a, String b) {
        aStack = stringToStack(a);
        bStack = stringToStack(b);
        sumStack = new Stack<Integer>();
        carryOver = 0;
    }

    private Stack<Integer> stringToStack(String string) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < string.length(); ++i) {
            char aChar = string.charAt(i);
            stack.push(Integer.parseInt(aChar + ""));
        }
        return stack;
    }
}
