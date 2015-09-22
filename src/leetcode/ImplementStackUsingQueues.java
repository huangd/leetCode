package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huangd on 9/21/15.
 */
public class ImplementStackUsingQueues {
    class MyStack {

        // TODO: two queues solution?
        Queue<Integer> pushQueue = new LinkedList<Integer>();
        Queue<Integer> popQueue = new LinkedList<Integer>();

        // Push element x onto stack.
        public void push(int x) {
            pushQueue.add(x);
        }

        // Removes the element on top of the stack.
        public void pop() {

        }

        // Get the top element.
        public int top() {

        }

        // Return whether the stack is empty.
        public boolean empty() {
            return false;
        }

        private void prepareForPopAndTop() {

        }
    }
}
