package com.vladuken.dao;

import com.vladuken.entity.User;
import com.vladuken.exceptions.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends CRUDDAO<User>{
    User getByEmail(String email) throws DAOException;

    User getByPassword(String password) throws DAOException;

}
