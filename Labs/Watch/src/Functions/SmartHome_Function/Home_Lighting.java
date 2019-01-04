package Functions.SmartHome_Function;

import static Tools.Input_Data.inputYesNo;

public class Home_Lighting implements Home_Device {
    private boolean isBroken;
    private boolean isTurnedOn;

    public Home_Lighting() {
        isBroken = false;
        isTurnedOn = false;
    }


    @Override
    public void turnOff() {
        if (isTurnedOn) {
            System.out.println("\n~~~Lighting is turned off!~~~");
            isTurnedOn = false;
        } else {
            System.out.println("\n~~~Already turned off!~~~");
        }
    }

    @Override
    public void turnOn() {
        generateProblem();
        showStatus();
        if (!isTurnedOn && !isBroken) {
            System.out.println("~~~Turning on...~~~");
            System.out.println("~~~Lighting is turned on!~~~");
            isTurnedOn = true;
        }
    }

    @Override
    public void changeStatus() {
        if (isBroken) {
            System.out.print("\nDo you want to repair lighting?(yes-no): ");
            if (inputYesNo()) {
                isBroken = false;
                System.out.println("~~~Repaired!~~~");
            } else {
                System.out.println("~~~Not repaired!~~~");

            }
        } else {
            System.out.println("\n~~~Nothing to repair!~~~");
        }
    }

    @Override
    public void showStatus() {
        if (isTurnedOn) {
            System.out.println("\n~~~Everything lights!~~~");
        } else {
            if (isBroken) {
                System.out.println("\n~~~One of the bulbs is broken!~~~");
            } else {
                System.out.println("\n~~~Everything works well!~~~");
            }
        }
    }

    private void generateProblem() {
        if (Math.random() * 10 < 2) {
            isBroken = true;
        }
    }
}
