/***
 * @author Rathanak
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        //Check if user want to insert, read, update, delete
        System.out.println("Enter 1 to insert, 2 to read, 3 to update or 4 to delete the student's information : ");
        Integer num = input.nextInt();
        switch (num)
        {
            case 1:
            {
                System.out.println("Enter 1 to insert a student's information or 2 for multiple insertion");
                Integer choice = input.nextInt();
                try {
                    insert(choice);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                break;
            case 2:
            {
                System.out.println("Enter 1 to read a student's information or 2 for multiple information");
                Integer choice = input.nextInt();
                try {
                    read(choice);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                break;
            case 3:
            {
                System.out.print("What do you want to update? : 1 for name, 2 for department, 3 for score :");
                Integer choice = input.nextInt();
                try {
                    update(choice);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                break;
            case 4:
            {
                System.out.print("Delete base on : 1-id, 2-name, 3-department, 4-score :");
                Integer choice = input.nextInt();
                try {
                    delete(choice);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                break;
            default:
                System.out.println("Wrong Input..");
                break;
        }
    }

    private static void delete(Integer choice) throws SQLException
    {
        switch (choice)
        {
            case 1:
            {
                //Delete base on Id
                System.out.print("Enter the Id: ");
                Integer id = input.nextInt();
                DataManager.delete(id);
                System.out.println("Done!!");
            }
                break;
            case 2:
            {
                //Delete base on department
                System.out.print("Enter the dept_name: ");
                String dept_name = input.next();
                DataManager.delete(dept_name);
                System.out.println("Done!!");
            }
                break;
            case 3:
            {
                //Delete base on score
                System.out.print("Enter the score: ");
                Double score = input.nextDouble();
                DataManager.delete(score);
                System.out.println("Done!!");
            }
                break;
            default:
                System.out.println("Wrong Input...");
                break;
        }
    }

    private static void update(Integer choice) throws SQLException
    {
        switch (choice)
        {
            case 1:
            {
                //Update name base on Id
                System.out.println("Enter the id of the student: ");
                Integer id = input.nextInt();
                System.out.print("Enter the new name: ");
                String name = input.next();

                DataManager.update(id, name);
                System.out.println("Done!!");
            }
                break;
            case 2:
            {
                //Update dept_name base on id
                System.out.print("Enter the id of student: ");
                Integer id = input.nextInt();
                System.out.print("Enter the new department: ");
                String department = input.next();

                DataManager.update(department, id);
                System.out.println("Done!!");
            }
                break;
            case 3:
            {
                //Update score base on id or dept_name
                System.out.print("Update base on : 1-Id or 2-Department: ");
                Integer mychoice = input.nextInt();
                if (mychoice == 1)
                {
                    System.out.println("Enter the id of the student: ");
                    Integer id = input.nextInt();
                    System.out.print("Enter the new score: ");
                    Double score = input.nextDouble();

                    DataManager.update(id, score);
                    System.out.println("Done!!");
                }
                else if(mychoice == 2)
                {
                    System.out.print("Enter the department of student: ");
                    String department = input.next();
                    System.out.print("Enter the new score: ");
                    Double score = input.nextDouble();

                    DataManager.update(department, score);
                    System.out.println("Done!!");
                }
            }
                break;
            default:
                System.out.println("Wrong Input...");
                break;
        }
    }

    private static void read(Integer choice) throws SQLException
    {
        switch (choice)
        {
            case 1:
            {
                //Read base on Id
                System.out.println("Enter the id of the student");
                Integer id = input.nextInt();

                Student stu = new DataManager().read(id);
                System.out.println(stu);
            }
                break;
            case 2:
            {
                //Read all
                ArrayList<Student> arr = new DataManager().read();

                arr.forEach(student ->
                {
                    System.out.println(student);
                });
            }
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
    }

    private static void insert(Integer choice) throws SQLException
    {
        switch (choice)
        {
            case 1:
            {
                //Single Insertion
                System.out.println("Enter student's id, name, department, score");
                DataManager.insert(new Student(input.nextInt(), input.next(), input.next(), input.nextDouble()));
                System.out.println("Done!!");
            }
                break;
            case 2:
            {
                //Multiple Insertion
                ArrayList<Student> arr = new ArrayList<Student>();

                Integer num = 1;
                while (num != 0)
                {
                    System.out.println("Enter student's id, name, department, score");
                    arr.add(new Student(input.nextInt(), input.next(), input.next(), input.nextDouble()));
                    System.out.println("Do you want to continue insert? : 1 for YES, 0 for NO");
                    num = input.nextInt();
                }

                new DataManager().insert(arr);
                System.out.println("Done!!");
            }
                break;
            default:
                System.out.println("Wrong Input..");
                break;
        }
    }
}