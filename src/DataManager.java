import java.sql.*;
import java.util.ArrayList;

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
        String query = "insert into student value('"+stu.getId()+"', '"+stu.getName()+"', '"+stu.getDept_name()+"', '"+stu.getScore()+"')";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    //Multiple Insertion
    public static void insert(ArrayList<Student> arr) throws SQLException
    {
        String query = "insert into student value";
        Statement statement = connection.createStatement();
        arr.forEach(stu ->
        {
            try {
                statement.addBatch(query + "('"+stu.getId()+"', '"+stu.getName()+"', '"+stu.getDept_name()+"', '"+stu.getScore()+"')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        statement.executeBatch();
    }

    //Read base on Id
    public static ArrayList<Student> read() throws SQLException
    {
        ArrayList<Student> arr = new ArrayList<Student>();
        Statement statement = connection.createStatement();
        ResultSet cursor = statement.executeQuery("select * from student");

        while (cursor.next())
        {
            Student stu = new Student();
            stu.setId(cursor.getInt("id"));
            stu.setName(cursor.getString("name"));
            stu.setDept_name(cursor.getString("dept_name"));
            stu.setScore(cursor.getDouble("score"));

            arr.add(stu);
        }
        return arr;
    }

    //Read all
    public static Student read(Integer id) throws SQLException
    {
        Student stu = new Student();

        PreparedStatement statement = connection.prepareStatement("select * from student where id = ?");
        statement.setInt(1, id);
        ResultSet cursor = statement.executeQuery();

        while (cursor.next())
        {
            stu.setId(cursor.getInt("id"));
            stu.setName(cursor.getString("name"));
            stu.setDept_name(cursor.getString("dept_name"));
            stu.setScore(cursor.getDouble("score")); }
        return stu;
    }

    //Update name base on Id
    public static void update(Integer id, String name) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("update student set name = '"+name+"' where id = '"+id+"'");
    }

    //Update dept_name base on Id
    public static void update(String department, Integer id) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("update student set dept_name = '"+department+"' where id = '"+id+"'");
    }

    //Update score base on Id
    public static void update(Integer id, Double score) throws SQLException
    {

        Statement statement = connection.createStatement();
        statement.executeUpdate("update student set score = '"+score+"' where id = '"+id+"'");
    }

    //Update score base on dept_name
    public static void update(String department, Double score) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("update student set score = '"+score+"' where dept_name = '"+department+"'");
    }

    //Delete base on dept_name
    public static void delete(String dept_name) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from student where dept_name = '"+dept_name+"'");
    }

    //Delete base on id
    public static void delete(Integer id) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from student where id = '"+id+"'");
    }

    //Delete base on dept_name
    public static void delete(Double score) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from student where score = '"+score+"'");
    }
}