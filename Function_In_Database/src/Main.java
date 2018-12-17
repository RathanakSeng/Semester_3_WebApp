import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.print("Enter Student's id: ");
        Integer id = input.nextInt();
        System.out.print("Enter Student's name: ");
        String name = input.next();
        System.out.print("Enter Student's department: ");
        String dept_name = input.next();
        System.out.print("Enter Student's score: ");
        Double score = input.nextDouble();

        DataManager.insertTransaction(new Student(id, name, dept_name, score));
    }
}
