package List_10.zad_2;

import static java.lang.Thread.sleep;

class CDM implements Runnable {

    private int deposits = 0;
    private BankAccount bankAccount;

    CDM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    int getDeposits() {
        return deposits;
    }

    @Override
    public void run() {
        while (bankAccount.getBankBalance() > 0) {
            try {
                sleep((long) (Math.random() * 2000));
                deposits += 100;
                bankAccount.lock();
                bankAccount.setBankBalance(bankAccount.getBankBalance() + 100);
                bankAccount.unlock();
                String text = "A bank balance after doing the deposit: ";
                System.out.println(text + bankAccount.getBankBalance());
                sleep((long) ((Math.random() * 2000)) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
