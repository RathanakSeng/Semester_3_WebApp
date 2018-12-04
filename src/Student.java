/*Data Transfer Object Class*/
public class Student
{
    private Integer id;
    private String name;
    private String dept_name;
    private Double score;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

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
