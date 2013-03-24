package leetcode;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * User: huangd
 * Date: 3/23/13
 * Time: 2:39 PM
 */
public class RecursiveIterator implements Iterator {
    private Stack<Iterator> stack = new Stack<Iterator>();

    public RecursiveIterator(Set nestedSet) {
        stack.push(nestedSet.iterator());
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            Iterator currentIterator = stack.peek();
            if (!currentIterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public Object next() {
        Iterator currentIterator = stack.peek();
        Object object = currentIterator.next();
        if (object instanceof Integer) {
            return object;
        } else {
            Set set = (Set) object;
            stack.push(set.iterator());
            return next();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
