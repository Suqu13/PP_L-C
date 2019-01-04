package Tools;

import java.util.Scanner;

import static Tools.Time_Correctness.checkCorrectness;

public class Input_Data {

    public static String inputHnMnS() {
        boolean correct = false;
        String time = null;
        Scanner sc = new Scanner(System.in);
        while (!correct) {
            time = sc.next();
            if (time.length() <= 8) {
                try {
                    Integer.parseInt(time.substring(0, 2));
                    Integer.parseInt(time.substring(3, 5));
                    if (time.length() > 5)
                        Integer.parseInt(time.substring(6, 8));
                    if (checkCorrectness(time))
                        correct = true;
                } catch (Exception ignored) {
                }
            }
        }
        return time;
    }


    public static int inputIntRange(int left, int right) {
        Scanner sc = new Scanner(System.in);
        boolean correct = false;
        int number = 0;
        while (!correct) {
            try {
                number = Integer.parseInt(sc.next());
                if (number >= left && number <= right) {
                    correct = true;
                }
            } catch (Exception ignored) {
            }
        }
        return number;
    }

    public static boolean inputYesNo() {
        boolean toCon = true;
        boolean toRet = false;
        Scanner sc = new Scanner(System.in);
        while (toCon) {
            String input = sc.nextLine();
            if (input.equals("yes") || input.toLowerCase().equals("yes")) {
                toCon = false;
                toRet = true;
            } else if (input.equals("no") || input.toLowerCase().equals("no")) {
                toCon = false;
                toRet = false;
            }
        }
        return toRet;
    }
}
