import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class StudentDao implements DAO<Student> {

    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "n@k123seng");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Student> get(long id) {
        Student student = new Student();
        String query = "select * from student where id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet cursor = statement.executeQuery(query);
            while (cursor.next()) {
                student.setName(cursor.getString("name"));
                student.setDept_name(cursor.getString("dept_name"));
                student.setScore(cursor.getDouble("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(student);
    }

    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet cursor = statement.executeQuery("select * from student");
            while (cursor.next()) {
                Student student = new Student();

                student.setName(cursor.getString("name"));
                student.setDept_name(cursor.getString("dept_name"));
                student.setScore(cursor.getDouble("score"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Boolean save(Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name, dept_name, score) value(?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDept_name());
            preparedStatement.setDouble(3, student.getScore());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer update(Student student, String[] params, Double score) {
        Integer rows = 0;
        student.setName(params[0]);
        student.setDept_name(params[1]);
        student.setScore(score);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update student set name = ? and  dept_name = ? and score = ? where id = ?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDept_name());
            preparedStatement.setDouble(3, student.getScore());
            preparedStatement.setInt(4, student.getId());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public Integer delete(Integer id) {
        Integer rows = 0;
        try {
            Statement statement = connection.createStatement();
            rows = statement.executeUpdate("delete * from student where id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
