package com.vladuken.service;

import com.vladuken.dao.UserDAO;
import com.vladuken.datalayer.MySQLConnection;
import com.vladuken.entity.User;
import com.vladuken.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMySQLService implements UserDAO {

    public void add(User user) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "INSERT INTO bookdatabase.user (email, password) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getPassword());

            preparedStatement.executeUpdate();

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("Add user error",e);
        }
    }

    public List<User> getAll() throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        List<User> userList = new ArrayList<User>();

        String sql = "SELECT id, email, password from bookdatabase.user";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while(resultSet.next()){
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                userList.add(user);
            }

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("Get all user error",e);
        }

        return userList;
    }

    public User getById(int id) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "SELECT id, email, password from bookdatabase.user where id=?";

        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));

            //preparedStatement.executeUpdate();

            free(preparedStatement);
        } catch (SQLException e) {
            throw new DAOException("Get by id error", e);
        }

        return user;
    }

    public User getByEmail(String email) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "SELECT id, email, password from bookdatabase.user where email=?";
        User user = getUserFromSQL(sql,email);

        return user;
    }

    public User getByPassword(String password) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "SELECT id, email, password from bookdatabase.user where password=?";

        User user = getUserFromSQL(sql,password);
        return user;
    }

    private User getUserFromSQL(String sql,String param) throws DAOException {
        Connection connection = MySQLConnection.getConnection();
        User user;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, param);

            ResultSet resultSet = preparedStatement.executeQuery();
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));

            //preparedStatement.executeUpdate();

            free(preparedStatement);
        } catch (SQLException e) {
            throw new DAOException("Get by password error", e);
        }
        return user;
    }

    public void update(User user) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "UPDATE bookdatabase.user SET id=? email=? password=?";

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());

            preparedStatement.executeUpdate();

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("Update user error",e);
        }

    }

    public void delete(User user) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "DELETE FROM bookdatabase.user WHERE id=?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.executeUpdate();

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("Delete user error",e);
        }
    }


    public void free(PreparedStatement preparedStatement) throws DAOException{
        if(preparedStatement!= null)
            try{
                preparedStatement.close();
            }catch (SQLException e){
                throw new DAOException("Close sql statement error",e);
            }
    }
}
