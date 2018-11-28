public class Student
{
    Integer id;
    String name;
    String dept_name;
    String grade;
    public Student()
    {
        this.id = 0;
        this.name = "";
        this.dept_name = "";
        this.grade = "";
    }
    public Student(Integer id, String name, String dept_name, String grade)
    {
        this.id = id;
        this.name = name;
        this.dept_name = dept_name;
        this.grade = grade;
    }

    @Override
    public String toString()
    {
        return name + "'s information\n" +
                "id : " + id + "\nname: " + name + "\ndepartment: " + dept_name + "\ngrade: " + grade + "\n" +
                "---------------------";
    }
}
