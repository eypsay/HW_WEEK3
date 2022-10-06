package com.sayilir.coder.dataAccess;

import com.sayilir.coder.entities.Category;

import java.util.List;

public interface BaseDao<T> {
    void save(T t);

    List<T> getAll();

    void printAll();

    void delete(int id);

    T update(int id, T t);
}
