package com.demodao;

import java.util.ArrayList;
import java.util.Optional;

public interface DAO<T> {

    T findById (int id);

    ArrayList<T> findAll();

    Boolean save (T t);

    Integer update (Integer id, T t);

    Integer delete (Integer id);
}
