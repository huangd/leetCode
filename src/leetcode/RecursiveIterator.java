package leetcode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

/**
 * User: huangd
 * Date: 3/23/13
 * Time: 2:39 PM
 */
public class RecursiveIterator implements Iterator {
    private Stack<Iterator> stack = new Stack<Iterator>();
    private Integer next = null;

    public RecursiveIterator(Set nestedSet) {
        stack.push(nestedSet.iterator());
    }

    @Override
    public boolean hasNext() {
        if (next == null) {
            if (stack.isEmpty()) {
                return false;
            } else {
                Iterator currentIterator = stack.peek();
                if (currentIterator.hasNext()) {
                    Object object = currentIterator.next();
                    if (object instanceof Integer) {
                        next = (Integer) object;
                        return true;
                    } else {
                        Set set = (Set) object;
                        stack.add(set.iterator());
                        return hasNext();
                    }
                } else {
                    stack.pop();
                    return hasNext();
                }
            }
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        if (next == null) {
            if (hasNext()) {
                return next();
            } else {
                throw new NoSuchElementException();
            }
        } else {
            Integer result = new Integer(next);
            next = null;
            return result;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
