package com.sayilir.coder.bussiness;

import com.sayilir.coder.entities.Category;

public interface BaseManager<T> {
    void add(T t);
    void delete(int id);
    void update(int id, T t);

}
