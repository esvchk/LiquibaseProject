package com.academy.course.liquibase.dao;

import java.io.Serializable;
import java.sql.SQLException;

public class DAOImpl<T> implements DAO<T> {

    @Override
    public T save(T t) throws SQLException {

        return null;
    }

    @Override
    public T get(Serializable id) throws SQLException {

        return null;
    }

    @Override
    public void update(T t) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }
}
