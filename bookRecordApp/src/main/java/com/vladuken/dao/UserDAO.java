package com.vladuken.dao;

import com.vladuken.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    //create
    void add(User user) throws SQLException;

    //read
    List<User> getAll() throws SQLException;

    User getById() throws SQLException;

    //update
    void update(User user) throws SQLException;

    //delete
    void delete(User user) throws SQLException;
}
