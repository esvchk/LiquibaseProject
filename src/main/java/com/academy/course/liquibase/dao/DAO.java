package com.academy.course.liquibase.dao;

import java.io.Serializable;

public interface DAO<T> {
    T save(T t);

    T get(Serializable id);

    void update(T t);

    void delete(Serializable id);
}
