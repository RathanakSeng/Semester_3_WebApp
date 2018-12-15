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
        String url = "jdbc:mysql://localhost:3306/java_database";
        String username = "root";
        String password = "n@k123seng";

        try(Connection con = DriverManager.getConnection(url, username, password)) {
            con.setAutoCommit(false);

            String query = "select * from student";

            Statement stat = con.createStatement();

            ResultSet result = stat.executeQuery(query);

            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet rowset = factory.createCachedRowSet();

            rowset.setTableName("student");

            rowset.populate(result);

            while (!quite) {
                  if(!readStudent(rowset)) continue;

                  updateStudent(rowset);

                  deleteStudent(rowset);

                  insertStudent(rowset);

                  saveChange(rowset, con);

                  askQuite();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void askQuite() {

        System.out.println("Do you want to continued (Y/N)? ");
        answer = input.next();

        quite = answer.equalsIgnoreCase("N");
    }

    private static void saveChange(CachedRowSet rowset, Connection con) {

        System.out.print("Do you want to save the change (Y/N)? ");
        answer = input.next();

        if (answer.equalsIgnoreCase("Y")) {
            try {
                rowset.acceptChanges(con);
            } catch (SQLException e) {
                System.out.println("Error commited to database: " + e);
            }
        }
    }

    private static void insertStudent(CachedRowSet rowset) throws SQLException {

        System.out.print("Do you want to add new student (Y/N)? ");
        answer = input.next();

        if (answer.equalsIgnoreCase("Y")) {
            System.out.print("Enter the student's name: ");
            String name = input.next();

            System.out.print("Enter student's department: ");
            String dept_name = input.next();

            System.out.print("Enter student's score: ");
            Double score = input.nextDouble();

            rowset.moveToInsertRow();
            rowset.updateNull("id");
            rowset.updateString("name", name);
            rowset.updateString("dept_name", dept_name);
            rowset.updateDouble("score", score);

            rowset.insertRow();
            rowset.moveToCurrentRow();
            System.out.println("Student has been added");
        }
    }

    private static void deleteStudent(CachedRowSet rowset) throws SQLException{

        System.out.print("Do you want to delete this student (Y/N)? ");
        answer = input.next();

        if(answer.equalsIgnoreCase("Y")) {
            rowset.deleteRow();
            System.out.println("The student has removed");
        }
    }

    private static void updateStudent(CachedRowSet rowset) throws SQLException {

        System.out.print("\nDo you want to update this student (Y/N)?: ");
        answer = input.next();

        if (answer.equalsIgnoreCase("Y")) {

            System.out.print("\tUpdate name or left blank for not: ");
            String name = input.next();

            System.out.print("\tUpdate department's name or left blank for not: ");
            String dept_name = input.next();

            System.out.print("\tUpdate score or left blank for not: ");
            String score = input.next();

//            rowset.updateNull("id");
            if (!name.equals("")) rowset.updateString("name", name);
            if (!dept_name.equals("")) rowset.updateString("dept_name", dept_name);
            if (!score.equals("")) rowset.updateString("score", score);

            rowset.updateRow();

            System.out.println("The student has been updated.");
        }
    }

    private static boolean readStudent(ResultSet rowset) throws SQLException {

        System.out.print("Enter the row's number: ");
        Integer row = input.nextInt();

        if (rowset.absolute(row)) {
            String statement = "Student at row " + row;
            String studentInfo = "%s: {%s - %s - %s - %s";
            System.out.format(studentInfo, statement, rowset.getString("id"), rowset.getString("name"), rowset.getString("dept_name"), rowset.getString("score"));
            return true;
        } else {
            System.out.println("There's no student at row " + row);
            return false;
        }
    }
}

/**
 * A CachedRowSet object is a container for rows of data that caches its rows in memory, which makes it possible to operate (scroll and update) without keeping the database connection open all the time.
 * A CachedRowSet object makes use of a connection to the database only briefly: while it is reading data to populate itself with rows, and again while it is committing changes to the underlying database. So the rest of the time, a CachedRowSet object is disconnected, even while its data is being modified. Hence it is called disconnected row set.
 * Being disconnected, a CachedRowSet object is much leaner than a ResultSet object, making it easier to pass a CachedRowSet object to another component in an application.
 * You can modify data in a CachedRowSet object, but the modifications are not immediately reflected in the database. You need to make an explicit request to accept accumulated changes (insert, update and delete rows). The CachedRowSet then reconnects to the database and issues SQL statements to commit the changes.
 */