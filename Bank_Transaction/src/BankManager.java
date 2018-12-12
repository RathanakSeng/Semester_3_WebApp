import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankManager {

    static Connection connection = null;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "n@k123seng");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Cannot get the connection");
        }
    }

    public static void transfer(Integer debitId, Integer creditId, Double cash) {

        try {
            PreparedStatement debitStat = connection.prepareStatement("update users set cash = cash - ? where id = ?");
            PreparedStatement creditStat = connection.prepareStatement("update users set cash = cash + ? where id = ?");

            debitStat.setDouble(1, cash);
            debitStat.setInt(2, debitId);

            creditStat.setDouble(1, cash);
            creditStat.setInt(2, creditId);

            debitStat.executeUpdate();
            creditStat.executeUpdate();
            saveRecord(debitId, creditId, cash);

            connection.commit();
            System.out.println("Done!!");
        } catch (SQLException ex) {
            try {
                connection.rollback();
                System.out.println("Transaction Failed");
            } catch (SQLException e) {
                System.out.println("Cannot Rollback");
            }
        }
    }

    public static void saveRecord(Integer debitId, Integer creditId, Double cash) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("insert into transactions(sender_id, receiver_id, cash) value (?, ?, ?) ");

        statement.setInt(1, debitId);
        statement.setInt(2, creditId);
        statement.setDouble(3, cash);

        statement.execute();
    }
}
