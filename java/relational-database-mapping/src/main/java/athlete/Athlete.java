package athlete;

public class Athlete {
    private final String name;
    private final String type;

    public Athlete(final String name, final String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getClub() {
        return "none";
    }

    public double getBattingAverage() {
        return 0.0;
    }

    public double getBowlingAverage() {
        return 0.0;
    }
}
