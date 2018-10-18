package com.vladuken.service;

import com.vladuken.dao.UserDAO;
import com.vladuken.datalayer.MySQLConnection;
import com.vladuken.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService extends MySQLConnection implements UserDAO {

    Connection connection = getConnection();

    public void add(User user) throws SQLException {

    }

    public List<User> getAll() throws SQLException {
        return null;
    }

    public User getById() throws SQLException {
        return null;
    }

    public void update(User user) throws SQLException {

    }

    public void delete(User user) throws SQLException {

    }
}
