import java.util.Optional;

public class Main {
    private static DAO studentDao;

    public static void main(String[] args) {

        studentDao = new StudentDao();

        // Here you can perform any operation using that studentDao object...

    }

    // this function will convert the Optional type to Student type
    private static Student getStudent(String name) {
        Optional<Student> user = studentDao.findByName(name);

        return user.orElseGet(
                () -> new Student("non-student", "no-dept_name")
        );
    }
}
