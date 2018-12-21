import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class FilteredRowSetTest
{
    private static final String[] NAMES = {
            "Bill Gates",
            "Steve Jobs",
            "Mark Zuckerberg",
            "Alan Turing",
            "Linus Torlvalds"
    };

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "n@k123seng");

        FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();
        frs.setCommand("select * from user");
        frs.execute(con);
        frs.setFilter(new SearchFilter("^[A-L].*"));
        dumpRs(frs);
    }

    private static void dumpRs(FilteredRowSet frs) throws SQLException{

        ResultSetMetaData rsmd = frs.getMetaData();
        int cc = rsmd.getColumnCount();
        while (frs.next()) {
            for (int i = 1; i <= cc; i++) {
                System.out.println(rsmd.getColumnLabel(i) + " = "
                        + frs.getObject(i) + " ");
            }
            System.out.println("");
        }
    }
}
