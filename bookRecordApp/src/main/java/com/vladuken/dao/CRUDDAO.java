package com.vladuken.dao;

import com.vladuken.exceptions.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface CRUDDAO<T> {
    //create
    void add(T t) throws DAOException;

    //read
    List<T> getAll() throws DAOException;

    T getById(int id) throws DAOException;

    //update
    void update(T t) throws DAOException;

    //delete
    void delete(T t) throws DAOException;
}

