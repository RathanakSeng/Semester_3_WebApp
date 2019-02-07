import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class StudentDao implements DAO<Student> {

    static Connection connection;

    // Get connection
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "n@k123seng");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Student> findByName (String myName) {
        Student student = new Student();try {
            PreparedStatement statement = connection.prepareStatement("select * from student where name = ?");
            statement.setString(1, myName);
            ResultSet cursor = statement.executeQuery();
            while (cursor.next()) {
                student.setName(cursor.getString("name"));
                student.setEmail(cursor.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(student);
    }

    @Override
    public ArrayList<Student> findAll () {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet cursor = statement.executeQuery("select * from student");
            while (cursor.next()) {
                Student student = new Student();

                student.setName(cursor.getString("name"));
                student.setEmail(cursor.getString("email"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Boolean save (Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name, email) value(?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer update (Student student, String[] params) {
        Integer rows = 0;
        student.setName(Objects.requireNonNull(params[0], "name cannot be null"));
        student.setEmail(Objects.requireNonNull(params[1], "email cannot be null"));
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update student set email = ? where name = ?");
            preparedStatement.setString(1, student.getEmail());
            preparedStatement.setString(2, student.getName());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public Integer delete (Student student) {
        Integer rows = 0;
        try {
            Statement statement = connection.createStatement();
            rows = statement.executeUpdate("delete from student where name = " + student.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
