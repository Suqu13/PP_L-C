package List_11.zad_4;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private final Semaphore waiter;
    private final Fork leftFork;
    private final Fork rightFork;

    Philosopher(String name, Semaphore waiter, Fork leftFork, Fork rightFork) {
        super(name);
        this.waiter = waiter;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void meditate() throws InterruptedException {
        System.out.println(getName() + ": meditation.");
        sleep(8000);
        System.out.println(getName() + ": end of meditation.");
    }


    private void eat() throws InterruptedException {
        waiter.acquire();
        leftFork.lock();
        rightFork.lock();
        System.out.println(getName() + ": eating.");
        sleep(4000);
        System.out.println(getName() + ": end of eating.");
        leftFork.unlock();
        rightFork.unlock();
        waiter.release();
    }

    @Override
    public void run() {
        try {
            boolean condition = true;
            while (condition) {
                meditate();
                eat();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
