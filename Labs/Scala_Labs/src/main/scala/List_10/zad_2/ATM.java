package List_10.zad_2;

import static java.lang.Thread.sleep;

class ATM implements Runnable {

    private int withdrawals = 0;
    private BankAccount bankAccount;

    ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    int getWithdrawals() {
        return withdrawals;
    }

    @Override
    public void run() {
        while (bankAccount.getBankBalance() > 0) {
            try {
                sleep((long) (Math.random() * 2000));
                withdrawals += 100;
                bankAccount.lock();
                bankAccount.setBankBalance(bankAccount.getBankBalance() - 100);
                bankAccount.unlock();
                String text = "A bank balance after doing the withdrawal: ";
                System.out.println(text + bankAccount.getBankBalance());
                sleep((long) ((Math.random() * 2000)) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
