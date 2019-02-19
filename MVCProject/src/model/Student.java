package model;

public class Student {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean validate(Student student) {
        if (student.getId().equalsIgnoreCase("AE11")) {
            return true;
        }
        return false;
    }
}
