package leetcode;

import java.util.Stack;

/**
 * User: huangd
 * Date: 4/6/13
 * Time: 11:37 PM
 */
public class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public Integer pop() {
        Integer integer = stack.pop();
        if (integer == minStack.peek()) {
            minStack.pop();
        }
        return integer;
    }

    public Integer push(Integer integer) {
        stack.push(integer);
        if (integer <= minStack.peek()) {
            minStack.push(integer);
        }
        return integer;
    }

    public Integer min() {
        return minStack.peek();
    }
}
