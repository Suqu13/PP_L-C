package List_11.zad_2;

import java.util.concurrent.Semaphore;

class IntCell_Semaphore {
    private int n = 0;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}

class Count_Semaphore extends Thread {
    private static IntCell_Semaphore n = new IntCell_Semaphore();
    private static Semaphore sem = new Semaphore(1);

    @Override
    public void run() {
        int temp;

        for (int i = 0; i < 200000; i++) {
            try {
                sem.acquire();
                temp = n.getN();
                n.setN(temp + 1);
                sem.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Count_Semaphore p = new Count_Semaphore();
        Count_Semaphore q = new Count_Semaphore();
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