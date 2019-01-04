package Functions.Clock_Function;

import Functions.Clock_Function.My_Imp.My_Alarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Tools.Input_Data.*;
import static Tools.PrintNRet.ioMakeIndex;
import static Tools.PrintNRet.printMark;

//TODO MOZE LEPSZE DZIEDZICZENIE?

public class Alarm_Function extends AbstractClock_Function {

    private List<My_Alarm> alarms;

    public Alarm_Function(String tittle) {
        super(tittle);
        alarms = new ArrayList<>();
    }

    @Override
    public String getTittle() {
        return super.getTittle();
    }

    @Override
    public void addAction() {
        System.out.print("\nSet time of alarm. (00:00 - 24:00): ");
        String newAlarm = inputHnMnS().substring(0, 5);
        System.out.print("Set type of alarm. (daily - once): ");
        boolean type = inputType();
        alarms.add(new My_Alarm(newAlarm, type));
    }

    @Override
    public void changeDetails() {
        if (alarms.isEmpty()) {
            System.out.println("~~~Nothing to change!~~~");
        } else {
            showAlarms();
            change(ioMakeIndex(1,alarms.size()));
        }
    }

    @Override
    public void showActions() {
        showAlarms();
    }

    @Override
    public void runFunction() {
        if (alarms.isEmpty()) {
            System.out.print("~~~Nothing to run!~~~\n");
        } else {
            showAlarms();
            System.out.println("\n" + (alarms.size() + 1) + ". Back");
            int input = ioMakeIndex(1, alarms.size()+1);
            if (input >= alarms.size())
                return;
            alarms.get(input).start();
        }
    }

    private void showAlarms() {
        refreshAlarmList();
        if (alarms.isEmpty()) {
            System.out.println("~~~Nothing to show!~~~");
        } else {
            String tittle = "####ALARMS####";
            System.out.println("\n" + tittle);

            int i = 0;
            for (My_Alarm alarm : alarms) {
                i++;
                System.out.println(i + ". " + alarm.getInfo());
            }
            printMark('#', tittle);
        }
    }

    private void change(int choose) {
        System.out.print("1. Cancel alarm\n2. Change alarm time\n3. Back");
        int i = ioMakeIndex(1,3);
        if (i == 1) {
            alarms.get(choose).cancel();
        } else if (i == 2) {
            alarms.get(choose).setAlarmTime(inputHnMnS().substring(0, 5), false);
        }
    }

    private void refreshAlarmList() {
        alarms.removeIf(My_Alarm::isToCancel);
    }

    private boolean inputType() {
        Scanner sc = new Scanner(System.in);
        boolean toCont = true;
        boolean toReturn = false;
        while (toCont) {
            String input = sc.nextLine();
            if (input.equals("daily") || input.toLowerCase().equals("daily")) {
                toCont = false;
                toReturn = true;
            } else if (input.equals("once") || input.toLowerCase().equals("once")) {
                toCont = false;
            }
        }
        return toReturn;
    }
}
