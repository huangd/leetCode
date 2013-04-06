package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: huangd
 * Date: 4/3/13
 * Time: 7:44 PM
 */
public class BlockingQueue<E> {
    private final List<E> list;
    private final int queueSize;
    private final Lock lock = new ReentrantLock();
    private final Condition emptyCondition = lock.newCondition();
    private final Condition fullCondition = lock.newCondition();

    public BlockingQueue(int queueSize) {
        this.queueSize = queueSize;
        list = new ArrayList<E>(queueSize);
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (list.isEmpty()) {
                emptyCondition.await();
            }
            E element = list.remove(0);
            fullCondition.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }

    public void put(E element) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == queueSize) {
                fullCondition.await();
            }
            list.add(element);
            emptyCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
