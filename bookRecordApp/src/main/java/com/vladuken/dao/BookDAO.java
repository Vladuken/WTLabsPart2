package com.vladuken.dao;

import com.vladuken.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    //create
    void add(Book book) throws SQLException;

    //read
    List<Book> getAll() throws SQLException;

    Book getById(int id) throws SQLException;

    //update
    void update(Book book) throws SQLException;

    //delete
    void delete(Book book) throws SQLException;
}
