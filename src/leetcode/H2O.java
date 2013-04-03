package leetcode;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: huangd
 * Date: 3/29/13
 * Time: 6:02 PM
 */
public class H2O {
    private AtomicInteger currentH = new AtomicInteger(0);
    private AtomicInteger currentO = new AtomicInteger(0);
    private Semaphore semaphoreH = new Semaphore(0);
    private Semaphore semaphoreO = new Semaphore(0);

    private int totalWater = 0;

    public void H() throws InterruptedException {
        currentH.incrementAndGet();
        update();
        semaphoreH.acquire();
    }

    public void O() throws InterruptedException {
        currentO.incrementAndGet();
        update();
        semaphoreO.acquire();
    }

    public synchronized void update() {
        if (currentH.get() >= 2 && currentO.get() >= 1) {
            currentH.addAndGet(-2);
            currentO.addAndGet(-1);
            semaphoreH.release(2);
            semaphoreO.release();
            totalWater += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int TOTAL_THREAD = 2000;
        int totalH = 0;
        int totalO = 0;
        H2O h2O = new H2O();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(TOTAL_THREAD);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < TOTAL_THREAD; ++i) {
            boolean isO = random.nextInt() % 3 == 0 ? true : false;
            if (isO) {
                new H2OThread(h2O, H2OType.O, cyclicBarrier).start();
                totalO++;
            } else {
                new H2OThread(h2O, H2OType.H, cyclicBarrier).start();
                totalH++;
            }
        }
        Thread.sleep(5000);
        System.out.println("Total H: " + totalH);
        System.out.println("Total O: " + totalO);
        System.out.println("SemaphoreO: " + h2O.semaphoreO.getQueueLength());
        System.out.println("SemaphoreH: " + h2O.semaphoreH.getQueueLength());
        System.out.println("Total H2O: " + h2O.totalWater);
    }
}

class H2OThread extends Thread {
    private H2O h2O;
    private H2OType h2OType;
    private CyclicBarrier cyclicBarrier;

    public H2OThread(H2O h2O, H2OType h2OType, CyclicBarrier cyclicBarrier) {
        this.h2O = h2O;
        this.h2OType = h2OType;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            if (h2OType == H2OType.H) {
                h2O.H();
            } else {
                h2O.O();
            }
        } catch (InterruptedException e) {
            ;
        } catch (BrokenBarrierException e) {
            ;
        }

    }
}

enum H2OType {
    H, O;
}