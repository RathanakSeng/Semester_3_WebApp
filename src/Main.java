import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Enter 1 to insert or 2 to read the student's data : ");
        Integer num = input.nextInt();
        switch (num)
        {
            case 1:
            {
                System.out.println("Enter 1 to insert a student's information or 2 for multiple insertion");
                Integer n = input.nextInt();
                switch (n)
                {
                    case 1:
                        insert();
                        break;
                    case 2:
                        insertMul();
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }
                break;
            }
            case 2:
            {
                System.out.println("Enter 1 to read a student's information or 2 for multiple information");
                Integer n = input.nextInt();
                switch (n)
                {
                    case 1:
                        read();
                        break;
                    case 2:
                        readMul();
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }
                break;
            }
            default:
                System.out.println("Wrong Input");
                break;
        }
    }

    private static void readMul()
    {
        ArrayList<Student> arr = new DataManager().read();

        arr.forEach(student ->
        {
            System.out.println(student);
        });
    }

    private static void read()
    {
        System.out.println("Enter the id of the student");
        Integer id = input.nextInt();

        Student stu = new DataManager().read(id);
        System.out.println(stu);
    }

    private static void insertMul()
    {
        ArrayList<Student> arr = new ArrayList<Student>();

        Integer num = 1;
        while (num != 0)
        {
            System.out.println("Enter student's id, name, department, grade");
            arr.add(new Student(input.nextInt(), input.next(), input.next(), input.next()));
            System.out.println("Do you want to continue insert? : 1 for YES, 0 for NO");
            num = input.nextInt();
        }

        new DataManager().insert(arr);
        System.out.println("Done!!");
    }

    private static void insert()
    {
        System.out.println("Enter student's id, name, department, grade");
        new DataManager().insert(new Student(input.nextInt(), input.next(), input.next(), input.next()));
        System.out.println("Done!!");
    }
}
