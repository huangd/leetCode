package leetcode;

import java.util.Random;

/**
 * User: huangd
 * Date: 3/29/13
 * Time: 6:02 PM
 */
public class H2O {

    private int currentH = 0;
    private int currentO = 0;
    private int releaseH = 0;
    private int releaseO = 0;

    private int totalWater = 0;

    public synchronized void H() throws InterruptedException {
        currentH += 1;
        update();
        while (releaseH <= 0) {
            wait();
        }
        releaseH -= 1;
    }

    public synchronized void O() throws InterruptedException {
        currentO += 1;
        update();
        while (releaseO <= 0) {
            wait();
        }
        releaseO -= 1;
    }

    public synchronized void update() {
        if (currentH >= 2 && currentO >= 1) {
            releaseH += 2;
            releaseO += 1;
            currentH -= 2;
            currentO -= 1;
            notifyAll();
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