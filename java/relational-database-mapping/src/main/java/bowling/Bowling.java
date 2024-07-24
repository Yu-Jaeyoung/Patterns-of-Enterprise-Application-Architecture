package bowling;

import cricket.Cricket;

public class Bowling extends Cricket {

    private final double bowlingAverage;

    public Bowling(final String name, final String type, final double battingAverage, final double bowlingAverage) {
        super(name, type, battingAverage);
        this.bowlingAverage = bowlingAverage;
    }

    public double getBowlingAverage() {
        return bowlingAverage;
    }
}
