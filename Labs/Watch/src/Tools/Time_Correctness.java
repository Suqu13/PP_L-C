package Tools;

public class Time_Correctness {


    public static boolean checkCorrectness(String time) {
        if (!(time.length() == 8 || time.length() == 5)) {
            return false;
        } else {
            if (24 > Integer.parseInt(time.substring(0, 2)) && 60 > Integer.parseInt(time.substring(3, 5))) {
                if (6 < time.length()) {
                    return 60 > Integer.parseInt(time.substring(6, 8));
                }
                return true;
            }
            return false;
        }
    }
}
