package Functions.Clock_Function;

import Functions.Clock_Function.My_Imp.My_Timer;

import java.util.ArrayList;
import java.util.List;

import static Tools.Input_Data.inputHnMnS;
import static Tools.Input_Data.inputIntRange;
import static Tools.PrintNRet.ioMakeIndex;
import static Tools.PrintNRet.printMark;


public class Timer_Function extends AbstractClock_Function {

    private List<My_Timer> timers;


    public Timer_Function(String tittle) {
        super(tittle);
        timers = new ArrayList<>();
    }

    @Override
    public String getTittle() {
        return super.getTittle();
    }

    @Override
    public void addAction() {
        System.out.print("\nSet timer. (00:00:00 - 23:59:59): ");
        String time = inputHnMnS();
        timers.add(new My_Timer(time));
    }

    @Override
    public void changeDetails() {
        if (timers.isEmpty()) {
            System.out.println("~~~Nothing to change!~~~");
        } else {
            showATimers();
            int input = ioMakeIndex(1, timers.size());
            change(input);
        }

    }

    @Override
    public void showActions() {
        showATimers();
    }

    @Override
    public void runFunction() {
        if (timers.isEmpty()) {
            System.out.println("~~~Nothing to run!~~~");
        } else {
            showATimers();
            System.out.println((timers.size() + 1) + ". Back");
            int input = ioMakeIndex(1, timers.size() + 1);
            if (input < timers.size())
                timers.get(input).start();
        }
    }

    private void showATimers() {
        refreshTimerList();
        if (timers.isEmpty()) {
            System.out.println("~~~Nothing to show!~~~");
        } else {
            int i = 0;
            String tittle = "####TIMERS####";
            System.out.println("\n" + tittle);

            for (My_Timer alarm : timers) {
                i++;
                System.out.println(i + ". Timer: " + alarm.getInfo());
            }
            printMark('#', tittle);
        }
    }

    private void change(int choose) {
        System.out.println("1. Cancel timer\n2. Back");
        int i = inputIntRange(1, 2);
        if (i == 1)
            timers.get(choose).cancel();
    }

    private void refreshTimerList() {
        timers.removeIf(My_Timer::isToCancel);
    }
}
