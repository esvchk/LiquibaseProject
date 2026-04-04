package com.academy.course.liquibase.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface DAO<T> {
    T save(T entity) throws SQLException;

    T get(Serializable id) throws SQLException;

    void update(T entity) throws SQLException;

    Integer delete(Serializable id) throws SQLException;

}
