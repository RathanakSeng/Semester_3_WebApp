import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import java.sql.*;

/**
 * @author Rathanak
 */
public class JoinRowSetExample
{
    public static void main(String[] args) throws Exception{

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "n@k123seng");

        JoinRowSet jrs = new JoinRowSetImpl();

        ResultSet rs_1 = con.createStatement().executeQuery("select dept_name from department");
        CachedRowSet crs_1 = new CachedRowSetImpl();
        crs_1.populate(rs_1);
        crs_1.setMatchColumn(1);
        jrs.addRowSet(crs_1);
        
        ResultSet rs_2 = con.createStatement().executeQuery("select dept_name from student");
        CachedRowSet crs_2 = new CachedRowSetImpl();
        crs_2.populate(rs_2);
        crs_2.setMatchColumn(1);
        jrs.addRowSet(crs_2);

        jrs.first();
        do {
            System.out.println(jrs.getString("dept_name"));
        } while (jrs.next());
    }

    /**
     * A simple rowSet technology is used to perform join operator in SQL
     */
}
