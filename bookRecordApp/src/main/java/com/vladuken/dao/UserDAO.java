package com.vladuken.dao;

import com.vladuken.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    //create
    void add(User user) throws SQLException, ClassNotFoundException;

    //read
    List<User> getAll() throws SQLException,ClassNotFoundException;

    User getById(int id) throws SQLException,ClassNotFoundException;

    //update
    void update(User user) throws SQLException,ClassNotFoundException;

    //delete
    void delete(User user) throws SQLException,ClassNotFoundException;
}
