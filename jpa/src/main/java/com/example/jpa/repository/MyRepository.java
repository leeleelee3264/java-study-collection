package com.example.jpa.repository;

import java.util.List;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-10
 * Description:
 */
public interface MyRepository<T> {

    void save(T t);

    T findOne(Long id);

    default List<T> findAll() {
        return null;
    }
}
