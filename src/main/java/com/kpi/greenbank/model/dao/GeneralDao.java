package com.kpi.greenbank.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDao<T> extends AutoCloseable {
    void add(T entity) throws SQLException;

    T findById(String id) throws SQLException;;

    void update(T entity) throws SQLException;;

    void delete(int id) throws SQLException;;

    void close() throws SQLException;;

}
