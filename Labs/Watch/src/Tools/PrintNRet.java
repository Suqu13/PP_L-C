package Tools;

import static Tools.Input_Data.inputIntRange;

public class PrintNRet {
    public static void printMark(char mark, String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(mark);
        }
        System.out.println();
    }

    public static int ioMakeIndex(int left, int righ) {
        System.out.print("\nSelect number. (" + left + "-" + righ + "): ");
        return inputIntRange(left, righ) - 1;
    }
}
