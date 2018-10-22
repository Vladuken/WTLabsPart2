package com.vladuken.service;

import com.vladuken.dao.UserDAO;
import com.vladuken.datalayer.MySQLConnection;
import com.vladuken.entity.Book;
import com.vladuken.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService extends MySQLConnection implements UserDAO {

    public void add(User user) throws SQLException,ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "INSERT INTO bookdatabase.user (email, password) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,user.getEmail());
        preparedStatement.setString(2,user.getPassword());

        preparedStatement.executeUpdate();

        free(preparedStatement);
    }

    public List<User> getAll() throws SQLException,ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();

        List<User> userList = new ArrayList<User>();

        String sql = "SELECT id, email, password from bookdatabase.user";

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

        return userList;
    }

    public User getById(int id) throws SQLException,ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "SELECT id, email, password from bookdatabase.user where id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));

        //preparedStatement.executeUpdate();

        free(preparedStatement);

        return user;
    }

    public void update(User user) throws SQLException,ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "UPDATE bookdatabase.user SET id=? email=? password=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setString(3,user.getPassword());

        preparedStatement.executeUpdate();

        free(preparedStatement);
    }

    public void delete(User user) throws SQLException,ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "DELETE FROM bookdatabase.user WHERE id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,user.getId());
        preparedStatement.executeUpdate();

        free(preparedStatement);
    }

    public void free(PreparedStatement preparedStatement) throws SQLException{
        if(preparedStatement!= null)
            preparedStatement.close();
    }
}
