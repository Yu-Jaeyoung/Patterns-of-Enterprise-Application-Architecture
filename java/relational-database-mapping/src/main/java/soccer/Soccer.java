package soccer;

import athlete.Athlete;

public class Soccer extends Athlete {

    private final String club;

    public Soccer(final String name, final String type, final String club) {
        super(name, type);
        this.club = club;
    }

    public final String getClub() {
        return club;
    }
}
