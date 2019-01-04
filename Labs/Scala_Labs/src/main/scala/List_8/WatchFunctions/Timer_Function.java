package List_8.WatchFunctions;

import java.util.ArrayList;
import java.util.List;

public class Timer_Function extends Function {

    private double startTime = -1;
    private int unit = 1;
    private List<Double> rounds = new ArrayList<>();

    private void clearSavedRounds() {
        rounds.clear();
        startTime = -1;
    }

    public void takeRound() {
        if (startTime == -1) {
            startTime = System.currentTimeMillis();
        } else if (rounds.isEmpty()) {
            rounds.add((startTime - System.currentTimeMillis()) / unit);
        } else {
            rounds.add(rounds.get(rounds.size() - 1) - (System.currentTimeMillis() / unit));
        }
    }

    @Override
    void setDetails() {
        //TODO there should be the mechanism for setting which unit we want to measure
    }


    @Override
    String checkState() {
        String measuredTime;
        return null;
    }


}
