public class Student
{
    Integer id;
    String name;
    String dept_name;
    Double score;
    public Student()
    {
        this.id = 0;
        this.name = "";
        this.dept_name = "";
        this.score = 0.00;
    }
    public Student(Integer id, String name, String dept_name, Double score)
    {
        this.id = id;
        this.name = name;
        this.dept_name = dept_name;
        this.score = score;
    }

    @Override
    public String toString()
    {
        return name + "'s information\n" +
                "id : " + id + "\nname: " + name + "\ndepartment: " + dept_name + "\nscore: " + score + "\n" +
                "---------------------";
    }
}
