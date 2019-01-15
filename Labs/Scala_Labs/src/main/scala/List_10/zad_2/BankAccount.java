package List_10.zad_2;

import java.util.concurrent.Semaphore;

class BankAccount {
    private int bankBalance = 1000;
    private Semaphore semaphore = new Semaphore(1);

    int getBankBalance() {
        return bankBalance;
    }

    void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }

    void lock(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void unlock() {
        semaphore.release();
    }
}
