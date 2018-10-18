package com.vladuken.service;

import com.mysql.cj.xdevapi.SqlDataResult;
import com.vladuken.dao.BookDAO;
import com.vladuken.datalayer.MySQLConnection;
import com.vladuken.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService extends MySQLConnection implements BookDAO {

    Connection connection = getConnection();

    public void add(Book book) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO bookdatabase.book (title, year ,author ,type) VALUES (?, ? ,? ,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setInt(2,book.getYear());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setString(4,book.getType());

            preparedStatement.executeUpdate();

        } catch(SQLException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            free(preparedStatement,connection);
        }
    }

    public List<Book> getAll() throws SQLException {
        List<Book> bookList = new ArrayList<Book>();

        String sql = "SELECT id, title, year, author, type from bookdatabase.book";
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(sql);

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
        }catch (SQLException e ){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            free(preparedStatement,connection);
        }
        return bookList;
    }

    public Book getById(int id) throws SQLException{
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, title, year, author, type from bookdatabase.book where id=?";

        Book book = new Book();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setYear(resultSet.getInt("year"));
            book.setAuthor(resultSet.getString("author"));
            book.setType(resultSet.getString("type"));

            //preparedStatement.executeUpdate();


        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            free(preparedStatement,connection);
        }

        return book;
    }

    public void update(Book book) throws SQLException{
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE bookdatabase.book SET id=? title=? year=? author=? type=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,book.getId());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setInt(3,book.getYear());
            preparedStatement.setString(4,book.getAuthor());
            preparedStatement.setString(5,book.getType());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            free(preparedStatement,connection);
        }
    }

    public void delete(Book book) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM bookdatabase.book WHERE id=?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,book.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            free(preparedStatement,connection);
        }
    }

    public void free(PreparedStatement preparedStatement, Connection connection) throws SQLException{
        if(preparedStatement!= null)
            preparedStatement.close();
        if(connection != null)
            connection.close();
    }
}
