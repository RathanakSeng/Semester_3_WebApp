package com.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String name;
    private String dept_name;
    private Double score;

    public Student () {}

    public Student (String name, String dept_name, Double score) {
        this.name = name;
        this.dept_name = dept_name;
        this.score = score;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getDept_name () {
        return dept_name;
    }

    public void setDept_name (String dept_name) {
        this.dept_name = dept_name;
    }

    public Double getScore () {
        return score;
    }

    public void setScore (Double score) {
        this.score = score;
    }

    @Override
    public String toString () {
        return name + " : " + dept_name + " : " + score;
    }
}
