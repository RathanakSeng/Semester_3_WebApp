import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.Scanner;

/**
 * @author Rathanak
 */
public class CachedRowSetExample {
    static Scanner input = new Scanner(System.in);
    static String answer;
    static Boolean quite = false;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "n@k123seng";

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            ResultSet cursor = con.createStatement().executeQuery("select * from users");

            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(cursor);

            while (crs.next()) {
                System.out.println(crs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/**
 * A CachedRowSet object is a container for rows of data that caches its rows in memory, which makes it possible to operate (scroll and update) without keeping the database connection open all the time.
 * A CachedRowSet object makes use of a connection to the database only briefly: while it is reading data to populate itself with rows, and again while it is committing changes to the underlying database. So the rest of the time, a CachedRowSet object is disconnected, even while its data is being modified. Hence it is called disconnected row set.
 * Being disconnected, a CachedRowSet object is much leaner than a ResultSet object, making it easier to pass a CachedRowSet object to another component in an application.
 * You can modify data in a CachedRowSet object, but the modifications are not immediately reflected in the database. You need to make an explicit request to accept accumulated changes (insert, update and delete rows). The CachedRowSet then reconnects to the database and issues SQL statements to commit the changes.
 */