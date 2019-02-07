import java.util.Optional;
public class StudentApplication {

    private static DAO userDao;

    public static void main(String[] args) {
        userDao = new StudentDao();
        Student student = getUser(1);
        System.out.println(student);

        Boolean insert = userDao.save(new Student("Wan", "History", 45.00));
        System.out.println(insert);
    }

    private static Student getUser(int id) {
        Optional<Student> user = userDao.get(id);

        return user.orElseGet(
                () -> new Student("non-student", "no-dept_name", 00.0)
        );
    }
}
