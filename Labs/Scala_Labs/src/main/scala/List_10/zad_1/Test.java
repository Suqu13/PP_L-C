package List_10.zad_1;

public class Test {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        ATM atm = new ATM(bankAccount);
        CDM cdm = new CDM(bankAccount);
        Thread ATMThread = new Thread(atm);
        Thread CDMThread = new Thread(cdm);

        ATMThread.start();
        CDMThread.start();

        try {
            ATMThread.join();
            CDMThread.join();
            System.out.println("\nYou are completely broke!");
            System.out.println("Deposits: " + cdm.getDeposits());
            System.out.println("Withdraws: " + atm.getWithdrawals());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
