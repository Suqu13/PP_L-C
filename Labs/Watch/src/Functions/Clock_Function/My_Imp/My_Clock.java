package Functions.Clock_Function.My_Imp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static Tools.PrintNRet.printMark;


public class My_Clock extends Thread implements My_Device {

    private String currentTime;
    private String currentDate;
    private String owner;

    private boolean isToCancel;


    public My_Clock() {
        super("Clock");
        owner = "You can set 'owner' manually!";
        currentTime = String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.MINUTES));
        currentDate = String.valueOf(LocalDate.now());
        isToCancel = true;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public void setToCancel(boolean toCancel) {
        isToCancel = toCancel;
    }

    @Override
    public void run() {
        display();
        while (!isToCancel) {
            if (!currentTime.equals(String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))) || !currentDate.equals(String.valueOf(LocalDate.now()))) {
                currentTime = String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.MINUTES));
                currentDate = String.valueOf(LocalDate.now());
                display();
            }
        }
    }
    @Override
    public void display() {
        String tittle = "####CLOCK#####";
        System.out.println("\n" + tittle);
        System.out.println("Owner: " + owner + "\n" + "Time: " + currentTime + "\n" + "Date: " + currentDate);
        printMark('#', tittle);
    }

    @Override
    public String getInfo() {
        return owner;
    }

    @Override
    public void cancel() {
        isToCancel = true;
        System.out.println("~~~Clock is turned off!~~~");
    }

    @Override
    public boolean isToCancel() {
        return isToCancel;
    }

}
