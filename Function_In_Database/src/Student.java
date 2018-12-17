public class Student
{
    private Integer id;
    private String name;
    private String dept_name;
    private Double score;

    public Student(Integer id, String name, String dept_name, Double score)
    {
        this.id = id;
        this.name = name;
        this.dept_name = dept_name;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public Double getScore() {
        return score;
    }
}
