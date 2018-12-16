import java.sql.*;

/**
 * @author Rathanak
 */

public class Type_1Example
{
    public static void main(String[] args) throws Exception {

        String dc = "sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:mdsn";

        String user = "root";
        String pass = "n@k123seng";

        Class.forName(dc);

        Connection con = DriverManager.getConnection(url, user, pass);
        System.out.println("Connected to: " + con.getMetaData().getDatabaseProductName());

        Statement statement = con.createStatement();
        String query = "insert into student(name, dept_name, score) value('Dara', 'History', '30.5')";
        statement.executeUpdate(query);

        con.close();
    }
}
