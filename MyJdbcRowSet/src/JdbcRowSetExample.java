import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 * @author Rathanak
 */
public class JdbcRowSetExample
{
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
        rs.setUrl("jdbc:mysql://localhost:3306/java_database");
        rs.setUsername("root");
        rs.setPassword("n@k123seng");

        rs.setCommand("select * from department");
        rs.execute();

        rs.first();
        do {
            System.out.println(rs.getString("name"));
        } while (rs.next());

    }
}
