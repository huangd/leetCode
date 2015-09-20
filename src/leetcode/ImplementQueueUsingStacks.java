package leetcode;

import java.util.Stack;

/**
 * Created by huangd on 9/20/15.
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> stackPush = new Stack<Integer>();
        Stack<Integer> stackPop = new Stack<Integer>();

        // Push element x to the back of queue.
        public void push(int x) {
            resetForPush();
            stackPush.add(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            preparePopAndPeek();
            stackPop.pop();
        }

        // Get the front element.
        public int peek() {
            preparePopAndPeek();
            return stackPop.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            resetForPush();
            return stackPush.isEmpty();
        }

        private void preparePopAndPeek() {
            while(!stackPush.isEmpty()) {
                stackPop.add(stackPush.pop());
            }
        }

        private void resetForPush() {
            while(!stackPop.isEmpty()) {
                stackPush.add(stackPop.pop());
            }
        }
    }
}
