package com.bean;

import java.io.Serializable;

public class MyBean implements Serializable {
    // Pojo is a plain old java object
    // Implements Serializable to convert to Bean class
    private Integer id;
    private String username;

    public Integer getId () {
        return id;
    }

    public String getUsername () {
        return username;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public void setUsername (String username) {
        this.username = username;
    }
}
