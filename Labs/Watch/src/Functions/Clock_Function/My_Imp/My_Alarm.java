package Functions.Clock_Function.My_Imp;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class My_Alarm extends Thread implements My_Device {
    private String alarmTime;
    private boolean alarmKind; //true - daily , false - once
    private boolean cancelAlarm;
    private boolean isToCancel;

    public My_Alarm(String alarmTime, boolean alarmKind) {
        super("Alarm");
        this.alarmTime = alarmTime;
        this.alarmKind = alarmKind;
        cancelAlarm = false;
        isToCancel = false;
    }

    @Override
    public void run() {
        boolean sameTime = false;
        System.out.println("\n>>>>>" + getName() + ": " + alarmTime + " type: " + alarmKind + " is running!<<<<<");
        do {
            boolean alarmRang = false;
            while (!alarmRang && !cancelAlarm) {
                String currentTime = String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.MINUTES));
                if (alarmTime.equals(currentTime)) {
                    if (!sameTime) {
                        display();
                        alarmRang = true;
                        sameTime = true;
                    }
                } else {
                    sameTime = false;
                }
            }
            if (cancelAlarm)
                return;
        }
        while (alarmKind);
        isToCancel = true;
    }

    public void setAlarmTime(String alarmTime, boolean alarmKind) {
        this.alarmKind = alarmKind;
        this.alarmTime = alarmTime;
    }

    @Override
    public void cancel() {
        cancelAlarm = true;
        isToCancel = true;
        System.out.println("~~~Alarm is " + alarmTime + " canceled!~~~");
    }

    @Override
    public void display() {
        System.out.println("\n^*^*^*^*^*^*^ \nALARM!: " + alarmTime + "\n^*^*^*^*^*^*^");
    }

    @Override
    public String getInfo() {
        String type;
        type = alarmKind ? "DAILY" : "ONCE";
        return getName() + " " + alarmTime + " Type: " + type;
    }

    @Override
    public boolean isToCancel() {
        return isToCancel;
    }
}
