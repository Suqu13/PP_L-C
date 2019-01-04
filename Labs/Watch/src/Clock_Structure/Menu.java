package Clock_Structure;

import Functions.Clock_Function.AbstractClock_Function;

import static Tools.PrintNRet.ioMakeIndex;
import static Tools.PrintNRet.printMark;

public class Menu implements Manager {

    public void show(String tittle) {
        System.out.println("\n" + tittle + "\n");
        System.out.println("1. Add");
        System.out.println("2. Change");
        System.out.println("3. Run");
        System.out.println("4. Show");
        System.out.println("5. Exit\n");
        printMark('#', tittle);
    }

    @Override

    public void callFunctions(AbstractClock_Function abstractClock_function) {
        boolean repeat = true;
        while (repeat) {
            show("####_" + abstractClock_function.getTittle() + "_####");
            int input = ioMakeIndex(1, 5);
            switch (input) {
                case 0:
                    abstractClock_function.addAction();
                    break;
                case 1:
                    abstractClock_function.changeDetails();
                    break;
                case 2:
                    abstractClock_function.runFunction();
                    break;
                case 3:
                    abstractClock_function.showActions();
                    break;
                default:
                    repeat = false;
                    break;
            }
        }
    }


}
