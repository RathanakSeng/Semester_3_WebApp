package com.demodao;

import com.manager.DataManager;
import com.model.Student;

import java.util.ArrayList;

public class StudentDao implements DAO<Student> {

    @Override
    public Student findById (int id) {
        return new DataManager().findById(id);
    }

    @Override
    public ArrayList<Student> findAll () {
        return new DataManager().findAll();
    }

    @Override
    public Boolean save (Student student) {
        return new DataManager().save(student);
    }

    @Override
    public Integer update(Integer id, Student student) {
        student.setId(id);
        return new DataManager().update(student);
    }

    @Override
    public Integer delete(Integer id) {
        return new DataManager().delete(id);
    }
}
