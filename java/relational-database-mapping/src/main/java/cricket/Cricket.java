package cricket;

import athlete.Athlete;

public class Cricket extends Athlete {

    private final double battingAverage;

    public Cricket(String name, String type, double battingAverage) {
        super(name, type);
        this.battingAverage = battingAverage;
    }

    public double getBattingAverage() {
        return battingAverage;
    }
}
