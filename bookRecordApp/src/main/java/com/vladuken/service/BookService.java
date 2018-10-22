package com.vladuken.service;

import com.mysql.cj.xdevapi.SqlDataResult;
import com.vladuken.dao.BookDAO;
import com.vladuken.datalayer.MySQLConnection;
import com.vladuken.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements BookDAO {

    public void add(Book book) throws SQLException,ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "INSERT INTO bookdatabase.book (title, year ,author ,type) VALUES (?, ? ,? ,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,book.getTitle());
        preparedStatement.setInt(2,book.getYear());
        preparedStatement.setString(3,book.getAuthor());
        preparedStatement.setString(4,book.getType());

        preparedStatement.executeUpdate();

        free(preparedStatement);
    }

    public List<Book> getAll() throws SQLException,ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        List<Book> bookList = new ArrayList<Book>();

        String sql = "SELECT id, title, year, author, type from bookdatabase.book";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        while(resultSet.next()){
            Book book = new Book();

            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setYear(resultSet.getInt("year"));
            book.setAuthor(resultSet.getString("author"));
            book.setType(resultSet.getString("type"));

            bookList.add(book);
        }

        free(preparedStatement);
        return bookList;
    }

    public Book getById(int id) throws SQLException,ClassNotFoundException{
        Connection connection = MySQLConnection.getConnection();

        String sql = "SELECT id, title, year, author, type from bookdatabase.book where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setYear(resultSet.getInt("year"));
        book.setAuthor(resultSet.getString("author"));
        book.setType(resultSet.getString("type"));

        //preparedStatement.executeUpdate();

        free(preparedStatement);

        return book;
    }

    public void update(Book book) throws SQLException,ClassNotFoundException{
        Connection connection = MySQLConnection.getConnection();

        String sql = "UPDATE bookdatabase.book SET id=? title=? year=? author=? type=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getTitle());
        preparedStatement.setInt(3,book.getYear());
        preparedStatement.setString(4,book.getAuthor());
        preparedStatement.setString(5,book.getType());

        preparedStatement.executeUpdate();

        free(preparedStatement);
    }

    public void delete(Book book) throws SQLException,ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "DELETE FROM bookdatabase.book WHERE id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,book.getId());
        preparedStatement.executeUpdate();

        free(preparedStatement);
    }

    public void free(PreparedStatement preparedStatement) throws SQLException{
        if(preparedStatement!= null)
            preparedStatement.close();
    }
}
