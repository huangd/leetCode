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

    public E take() {
        try {
            lock.lock();
            while (list.isEmpty()) {
                emptyCondition.await();
            }
            E element = list.remove(0);
            fullCondition.signalAll();
            return element;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void put(E element) {
        try {
            lock.lock();
            while (list.size() == queueSize) {
                fullCondition.await();
            }
            list.add(element);
            emptyCondition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
