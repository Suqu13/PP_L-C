package Functions.Clock_Function.My_Imp;

public class My_Timer extends Thread implements My_Device {
    private String givenTime;
    private int timeToMeasure;
    private boolean isToCancel;

    public My_Timer(String givenTime) {
        super("Timer");
        this.givenTime = givenTime;
        timeToMeasure = parseGivenTime();
        isToCancel = false;
    }

    private int parseGivenTime() {
        int hoursToSec = Integer.parseInt(givenTime.substring(0, 2)) * 3600;
        int minutesToSec = Integer.parseInt(givenTime.substring(3, 5)) * 60;
        int seconds = Integer.parseInt(givenTime.substring(6, 8));
        return hoursToSec + minutesToSec + seconds;
    }

    @Override
    public void run() {
        System.out.println("\n>>>>>"+getName() + " " + givenTime + " is running!<<<<<");
        while (!isToCancel) {
            try {
                Thread.sleep(1000);
                timeToMeasure--;
                if (timeToMeasure <= 0) {
                    display();
                    isToCancel = true;
                    return;
                }
            } catch (InterruptedException exception) {
                System.out.println(exception.toString());
            }
        }
    }

    @Override
    public String getInfo() {
        return givenTime;
    }

    @Override
    public void display() {
        System.out.println("\n^*^*^*^*^*^*^ \nTIMER!: " + givenTime + "\n^*^*^*^*^*^*^");
    }

    @Override
    public void cancel() {
        isToCancel = true;
        System.out.println("~~~Timer is " + givenTime + " canceled!~~~");
    }

    @Override
    public boolean isToCancel() {
        return isToCancel;
    }
}
