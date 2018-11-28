import java.io.FileNotFoundException;
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
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void insert(Student stu)
    {
        String query = "insert into student value('"+stu.id+"', '"+stu.name+"', '"+stu.dept_name+"', '"+stu.grade+"')";
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

    public void insert(ArrayList<Student> arr)
    {
        String query = "insert into student value";
        try (Statement statement = connection.createStatement())
        {
            arr.forEach(stu ->
            {
                try {
                    statement.addBatch(query + "('"+stu.id+"', '"+stu.name+"', '"+stu.dept_name+"', '"+stu.grade+"')");
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

    public ArrayList<Student> read()
    {
        ArrayList<Student> arr = new ArrayList<Student>();

        try
        {
            Statement statement = connection.createStatement();
            ResultSet cursor = statement.executeQuery("select * from student");

            while (cursor.next())
            {
                Student stu = new Student();
                stu.id = cursor.getInt("id");
                stu.name = cursor.getString("name");
                stu.dept_name = cursor.getString("dept_name");
                stu.grade = cursor.getString("grade");

                arr.add(stu);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return arr;
    }

    public Student read(Integer id)
    {
        Student stu = new Student();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet cursor = statement.executeQuery("select * from student where id = '"+id+"'");

            while (cursor.next())
            {
                stu.id = cursor.getInt("id");
                stu.name = cursor.getString("name");
                stu.dept_name = cursor.getString("dept_name");
                stu.grade = cursor.getString("grade");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return stu;
    }
}
