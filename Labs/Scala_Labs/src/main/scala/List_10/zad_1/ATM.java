package List_10.zad_1;

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
                Thread.sleep((long) (Math.random() * 2000));
                withdrawals += 100;
                bankAccount.setBankBalance(bankAccount.getBankBalance() - 100);
                String text = "A bank balance after doing the withdrawal: ";
                System.out.println(text + bankAccount.getBankBalance());
                Thread.sleep((long) ((Math.random() * 2000)) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
