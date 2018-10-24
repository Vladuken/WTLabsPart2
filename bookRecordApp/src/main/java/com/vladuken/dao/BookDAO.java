package com.vladuken.dao;

import com.vladuken.entity.Book;
import com.vladuken.exceptions.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO extends CRUDDAO<Book> {
    List<Book> getByTitle(String title) throws DAOException;

    List<Book> getByAuthor(String author) throws DAOException;

    List<Book> getByYear(int year) throws DAOException;
}
