package leetcode;

import java.util.Random;
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
        int totalH = 0;
        int totalO = 0;
        H2O h2O = new H2O();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 500; ++i) {
            boolean isO = random.nextInt() % 3 == 0 ? true : false;
            if (isO) {
                new H2OThread(h2O, H2OType.O).start();
                totalO++;
            } else {
                new H2OThread(h2O, H2OType.H).start();
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

    public H2OThread(H2O h2O, H2OType h2OType) {
        this.h2O = h2O;
        this.h2OType = h2OType;
    }

    @Override
    public void run() {
        if (h2OType == H2OType.H) {
            try {
                h2O.H();
            } catch (InterruptedException e) {
                return;
            }
        } else {
            try {
                h2O.O();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

enum H2OType {
    H, O;
}