package com.vladuken.service;

import com.vladuken.dao.BookDAO;
import com.vladuken.datalayer.MySQLConnection;
import com.vladuken.entity.Book;
import com.vladuken.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookMySQLService implements BookDAO {

    public void add(Book book) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "INSERT INTO bookdatabase.book (title, year ,author ,type) VALUES (?, ? ,? ,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getYear());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getType());

            preparedStatement.executeUpdate();

            free(preparedStatement);
        } catch (SQLException e) {
            throw new DAOException("SQL statement error", e);
        }
    }

    public List<Book> getAll() throws DAOException {
        Connection connection = MySQLConnection.getConnection();
        List<Book> bookList = new ArrayList<Book>();

        String sql = "SELECT id, title, year, author, type from bookdatabase.book";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                bookList.add(createBookFrom(resultSet));
            }

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("SQL statement error", e);
        }

        return bookList;
    }

    public Book getById(int id) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "SELECT id, title, year, author, type from bookdatabase.book where id=?";
        Book book;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            book = createBookFrom(resultSet);

            //preparedStatement.executeUpdate();

            free(preparedStatement);
        } catch (SQLException e) {
            throw new DAOException("SQL statement error", e);
        }

        return book;
    }



    public List<Book> getByTitle(String title) throws DAOException {
        String sql = "SELECT id, title, year, author, type from bookdatabase.book where title=?";
        List<Book> bookList = getListFromSQL(sql,title);

        return bookList;
    }

    public List<Book> getByAuthor(String author) throws DAOException {
        List<Book> bookList;

        String sql = "SELECT id, title, year, author, type from bookdatabase.book where author=?";
        bookList = getListFromSQL(sql,author);

        return bookList;
    }

    private List<Book> getListFromSQL(String sql,String param) throws DAOException{
        Connection connection = MySQLConnection.getConnection();
        List<Book> bookList = new ArrayList<Book>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,param);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                bookList.add(createBookFrom(resultSet));
            }

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("SQL statement error", e);
        }
        return bookList;
    }

    public List<Book> getByYear(int year) throws DAOException {
        Connection connection = MySQLConnection.getConnection();
        List<Book> bookList = new ArrayList<Book>();

        String sql = "SELECT id, title, year, author, type from bookdatabase.book where year=?";

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,year);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                bookList.add(createBookFrom(resultSet));
            }

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("SQL statement error", e);
        }

        return bookList;
    }

    public Book createBookFrom(ResultSet resultSet) throws DAOException{
        Book book = new Book();

        try{

            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setYear(resultSet.getInt("year"));
            book.setAuthor(resultSet.getString("author"));
            book.setType(resultSet.getString("type"));
        }catch (SQLException e){
            throw new DAOException("Create book object from database error",e);
        }

        return book;
    }

    public void update(Book book) throws DAOException{
        Connection connection = MySQLConnection.getConnection();

        String sql = "UPDATE bookdatabase.book SET id=? title=? year=? author=? type=?";

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,book.getId());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setInt(3,book.getYear());
            preparedStatement.setString(4,book.getAuthor());
            preparedStatement.setString(5,book.getType());

            preparedStatement.executeUpdate();

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("Book update error",e);
        }

    }

    public void delete(Book book) throws DAOException {
        Connection connection = MySQLConnection.getConnection();

        String sql = "DELETE FROM bookdatabase.book WHERE id=?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,book.getId());
            preparedStatement.executeUpdate();

            free(preparedStatement);
        }catch (SQLException e){
            throw new DAOException("SQL statement error", e);
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
