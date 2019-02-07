package com.bean;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer id;
    private String name;

    public Student () {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
