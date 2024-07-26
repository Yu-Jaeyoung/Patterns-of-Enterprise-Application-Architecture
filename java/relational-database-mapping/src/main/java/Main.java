import bowling.Bowling;
import cricket.Cricket;
import soccer.Soccer;

public class Main {
    public static void main(String[] args) {
        AthleteDatabase.dropTable();
        AthleteDatabase.createTable();
        AthleteDatabase.add(new Soccer("김축구", "Soccer", "명문축구구단"));
        AthleteDatabase.add(new Cricket("김크켓", "Criket", 0.71));
        AthleteDatabase.add(new Bowling("김볼링", "Bowling", 0.76, 100));
        AthleteDatabase.readTable();
    }
}
