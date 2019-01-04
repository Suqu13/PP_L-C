package Clock_Structure;

import Functions.Clock_Function.AbstractClock_Function;
import Functions.Clock_Function.Alarm_Function;
import Functions.Clock_Function.CurrentTime_Function;
import Functions.Clock_Function.Timer_Function;
import Functions.SmartHome_Function.Home_Lighting;

import java.util.ArrayList;
import java.util.List;

import static Tools.Input_Data.inputIntRange;
import static Tools.PrintNRet.ioMakeIndex;
import static Tools.PrintNRet.printMark;

public class Main_Menu implements Manager {
    Menu menu = new Menu();
    List<AbstractClock_Function> fun;
    Home_Lighting lighting;

    public Main_Menu() {
        fun = new ArrayList<>();
        fun.add(new CurrentTime_Function("Clock"));
        fun.add(new Alarm_Function("Alarms"));
        fun.add(new Timer_Function("Timer"));
        lighting = new Home_Lighting();
    }

    public void show(String tittle) {
        int i = 1;
        System.out.println("\n" + tittle + "\n");
        for (AbstractClock_Function function : fun) {
            System.out.println(i + ". " + function.getTittle());
            i++;
        }
        System.out.println(i + ". Lighting");
        System.out.println((i + 1) + ". Exit\n");
        printMark('#', tittle);

    }

    public void callFunctions(AbstractClock_Function abstractClock_function) {
        boolean cont = true;
        while (cont) {
            show("####_SMART HOME MANAGER_####");
            int input = ioMakeIndex(1, fun.size() + 2);
            if (input < fun.size()) {
                menu.callFunctions(fun.get(input));
            } else if (input == fun.size()) {
                lightingCall();
            } else {
                cont = false;
            }
        }
    }

    private void lightingCall() {
        boolean toCon = true;
        while (toCon) {
            String tittle = "####_LIGHTING_####";
            System.out.println("\n" + tittle + "\n");
            System.out.println("1. Turn Off");
            System.out.println("2. Turn On");
            System.out.println("3. Change status");
            System.out.println("4. Show status");
            System.out.println("5. Back\n");
            printMark('#', tittle);
            int input = ioMakeIndex(1, 5);
            switch (input) {
                case 0:
                    lighting.turnOff();
                    break;
                case 1:
                    lighting.turnOn();
                    break;
                case 2:
                    lighting.changeStatus();
                    break;
                case 3:
                    lighting.showStatus();
                    break;
                default:
                    toCon = false;
                    break;
            }
        }
    }
}
