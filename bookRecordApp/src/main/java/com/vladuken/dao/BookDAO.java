package com.vladuken.dao;

import com.vladuken.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    //create
    void add(Book book) throws SQLException,ClassNotFoundException;

    //read
    List<Book> getAll() throws SQLException, ClassNotFoundException;

    Book getById(int id) throws SQLException,ClassNotFoundException;

    //update
    void update(Book book) throws SQLException,ClassNotFoundException;

    //delete
    void delete(Book book) throws SQLException,ClassNotFoundException;
}
