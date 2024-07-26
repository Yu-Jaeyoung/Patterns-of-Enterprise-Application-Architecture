import athlete.Athlete;
import bowling.Bowling;
import config.database.Database;
import cricket.Cricket;
import java.sql.ResultSet;
import java.sql.SQLException;
import soccer.Soccer;

public class AthleteDatabase {

    public static void dropTable() {
        String sql = "DROP TABLE IF EXISTS athlete";

        try (var conn = Database.connect()) {
            var stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS athlete ("
                + "name TEXT,"
                + "club TEXT,"
                + "batting_average REAL,"
                + "bowling_average REAL,"
                + "type TEXT"
                + ")";

        try (var conn = Database.connect()) {
            var stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int add(Athlete athlete) {

        String sql = "INSERT INTO " +
                "athlete(name, club, batting_average, bowling_average, type)" +
                " VALUES (?,?,?,?,?)";

        String name = athlete.getName();
        String type = athlete.getType();
        String club = null;
        double battingAverage = 0.0;
        double bowlingAverage = 0.0;

        if (athlete instanceof Soccer) {
            club = ((Soccer) athlete).getClub();
        }

        if (athlete instanceof Cricket) {
            battingAverage = ((Cricket) athlete).getBattingAverage();
        }

        if (athlete instanceof Bowling) {
            battingAverage = ((Bowling) athlete).getBattingAverage();
            bowlingAverage = ((Bowling) athlete).getBowlingAverage();
        }

        try (var conn = Database.connect()) {
            var pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, club);
            pstmt.setDouble(3, battingAverage);
            pstmt.setDouble(4, bowlingAverage);
            pstmt.setString(5, type);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void readTable() {
        String sql = "SELECT * FROM athlete";

        try (var conn = Database.connect()) {
            var stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String club = resultSet.getString("club");
                String type = resultSet.getString("type");
                double battingAverage = resultSet.getDouble("batting_average");
                double bowlingAverage = resultSet.getDouble("bowling_average");
                System.out.println(name + ", " + club + ", " + type + ", " + battingAverage + ", " + bowlingAverage);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
