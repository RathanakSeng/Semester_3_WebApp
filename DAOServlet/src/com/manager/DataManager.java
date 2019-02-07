package com.manager;
import com.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class DataManager {
    private static Connection connection = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "n@k123seng");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> findAll () {
        ArrayList<Student> students = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "select * from student";

            ResultSet cursor = statement.executeQuery(query);
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

    public Student findById (Integer id) {

        Student student = new Student();
        String query = "select * from student where id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet cursor = statement.executeQuery(query);
            while (cursor.next()) {
                student.setName(cursor.getString("name"));
                student.setDept_name(cursor.getString("dept_name"));
                student.setScore(cursor.getDouble("score"));
                System.out.println("\n\n\n" + student + "\n\n\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Boolean save (Student student) {
        Boolean insert = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name, dept_name, score) value(?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDept_name());
            preparedStatement.setDouble(3, student.getScore());
            insert = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    public Integer update (Student student) {
        Integer rows = 0;
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

    public Integer delete (Integer id) {
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
