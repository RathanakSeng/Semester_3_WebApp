import javax.sql.RowSet;
import javax.sql.rowset.Predicate;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFilter implements Predicate
{
    private Pattern pattern;

    public SearchFilter(String searchRegex) {

        if (searchRegex != null && !searchRegex.isEmpty()) {
            pattern = Pattern.compile(searchRegex);
        }
    }
    @Override
    public boolean evaluate(RowSet rs) {
        System.out.println("SearchFilter.evaluate called");
        try {
            if (!rs.isAfterLast()) {
                String name = rs.getString("name");
                System.out.println(String.format("Searching for pattern '%s' in %s", pattern.toString(), name));
                Matcher matcher = pattern.matcher(name);
                return matcher.matches();
            } else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean evaluate(Object value, int column) throws SQLException {
        throw new UnsupportedOperationException("Unsupported yet");
    }

    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {
        throw new UnsupportedOperationException("Unsupported yet");
    }
}
