import java.sql.*;

public class DataManager
{
    private static Connection connection = null;
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "n@k123seng");
            /*To Avoid NullPointerException we must create statement separately*/
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Single Insertion
    public static void insert(Student stu) throws SQLException
    {
        CallableStatement cs = connection.prepareCall("{call insertrecord (?, ?, ?, ?)}");
        cs.setInt(1, stu.getId());
        cs.setString(2, stu.getName());
        cs.setString(3, stu.getDept_name());
        cs.setDouble(4, stu.getScore());
        cs.execute();
        System.out.println("Done");
    }

    public static void insertTransaction(Student stu)
    {
        /*Set Auto Commit to false*/
        try {
            connection.setAutoCommit(false);
            PreparedStatement cs = connection.prepareStatement("insert into student value(?, ?, ?, ?)");

            cs.setInt(1, stu.getId());
            cs.setString(2, stu.getName());
            cs.setString(3, stu.getDept_name());
            cs.setDouble(4, stu.getScore());
            cs.execute();

            PreparedStatement css = connection.prepareStatement("insert int student value(?, ?, ?, ?)");
            css.setInt(1, stu.getId());
            css.setString(2, stu.getName());
            css.setString(3, stu.getDept_name());
            css.setDouble(4, stu.getScore());
            css.execute();

            connection.commit();
            System.out.println("Done");
        } catch (SQLException e) {
            try {
                connection.rollback();
                System.out.println("Rollback");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}
