package List_11.zad_2;

import java.util.concurrent.Semaphore;

class IntCell_Monitor {
    private int n = 0;
    private boolean blockade = true;

    public synchronized int getN() {
        while (!blockade) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        blockade = false;
        notifyAll();
        return n;
    }

    public synchronized void setN(int n) {
        while (blockade) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        blockade = true;
        notifyAll();
    }
}

class Count_Monitor extends Thread {
    private static IntCell_Monitor n = new IntCell_Monitor();


    @Override
    public void run() {
        int temp;

        for (int i = 0; i < 200000; i++) {
                temp = n.getN();
                n.setN(temp + 1);

        }
    }


    public static void main(String[] args) {
        Count_Monitor p = new Count_Monitor();
        Count_Monitor q = new Count_Monitor();
        p.start();
        q.start();
        try {
            p.join();
            q.join();
        } catch (InterruptedException e) {
        }
        System.out.println("The value of n is " + n.getN());
    }
}