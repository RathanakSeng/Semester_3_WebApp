import java.sql.*;
import java.util.ArrayList;

public class DataManager
{
    static Connection connection;
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
    public static void insert(Student stu)
    {
        String query = "insert into student value('"+stu.getId()+"', '"+stu.getName()+"', '"+stu.getDept_name()+"', '"+stu.getScore()+"')";
        try
        {
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Multiple Insertion
    public static void insert(ArrayList<Student> arr)
    {
        String query = "insert into student value";
        try (Statement statement = connection.createStatement())
        {
            arr.forEach(stu ->
            {
                try {
                    statement.addBatch(query + "('"+stu.getId()+"', '"+stu.getName()+"', '"+stu.getDept_name()+"', '"+stu.getScore()+"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            statement.executeBatch();
            statement.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Read base on Id
    public static ArrayList<Student> read()
    {
        ArrayList<Student> arr = new ArrayList<Student>();

        try
        {
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
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return arr;
    }

    //Read all
    public static Student read(Integer id)
    {
        Student stu = new Student();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet cursor = statement.executeQuery("select * from student where id = '"+id+"'");

            while (cursor.next())
            {
                stu.setId(cursor.getInt("id"));
                stu.setName(cursor.getString("name"));
                stu.setDept_name(cursor.getString("dept_name"));
                stu.setScore(cursor.getDouble("score"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return stu;
    }

    //Update name base on Id
    public static void update(Integer id, String name)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update student set name = '"+name+"' where id = '"+id+"'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Update dept_name base on Id
    public static void update(String department, Integer id)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update student set dept_name = '"+department+"' where id = '"+id+"'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Update score base on Id
    public static void update(Integer id, Double score)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update student set score = '"+score+"' where id = '"+id+"'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Update score base on dept_name
    public static void update(String department, Double score)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update student set score = '"+score+"' where dept_name = '"+department+"'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Delete base on dept_name
    public static void delete(String dept_name)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from student where dept_name = '"+dept_name+"'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Delete base on id
    public static void delete(Integer id)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from student where id = '"+id+"'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Delete base on dept_name
    public static void delete(Double score)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from student where score = '"+score+"'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
