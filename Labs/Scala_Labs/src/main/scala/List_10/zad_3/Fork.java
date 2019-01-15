package List_10.zad_3;

import java.util.concurrent.Semaphore;

class Fork {
    private final Semaphore semaphore;

    Fork() {
        this.semaphore = new Semaphore(1);
    }

    void lock() throws InterruptedException {
        semaphore.acquire();
    }

    void unlock() {
        semaphore.release();
    }
}
