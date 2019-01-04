package Functions.Clock_Function;

import Functions.Clock_Function.My_Imp.My_Clock;

import java.util.Scanner;

import static Tools.PrintNRet.ioMakeIndex;

public class CurrentTime_Function extends AbstractClock_Function {

    private My_Clock my_clock;

    public CurrentTime_Function(String tittle) {
        super(tittle);
        my_clock = new My_Clock();

    }

    @Override
    public String getTittle() {
        return super.getTittle();
    }


    @Override
    public void addAction() {
        System.out.println("~~~Not supported!~~~");
    }

    @Override
    public void changeDetails() {
        if(my_clock.isToCancel()) {
            System.out.println("~~~Clock is turned off!~~~");
        } else {
            System.out.println("1. Change owner");
            System.out.println("2. Turn OFF");
            System.out.println("3. Back");
            int input = ioMakeIndex(1,3);
            if (input == 0) {
                System.out.print("\nNew owner name: ");
                Scanner sc = new Scanner(System.in);
                my_clock.setOwner(sc.next());
            } else if (input == 1) {
                my_clock.cancel();
            }
        }
    }

    @Override
    public void showActions() {
        System.out.println("\nOwner: " + my_clock.getInfo());
    }

    @Override
    public void runFunction() {
        my_clock.start();
        my_clock.setToCancel(false);
    }




}
