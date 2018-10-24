package com.vladuken.service;

import com.vladuken.dao.BookDAO;
import com.vladuken.entity.Book;
import com.vladuken.exceptions.DAOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class BookMySQLServiceTest {

    BookDAO bookService;
    Book book;
    @Before
    public void before(){
        bookService = new BookMySQLService();
        book = new Book();
        book.setTitle("AAAA");
        book.setAuthor("BBBBB");
        book.setType("admin");
        book.setYear(1900);
    }

    @After
    public void after(){
        bookService = null;
        book = null;
    }

    @Test
    public void add() throws DAOException {
        bookService.add(book);
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void getByTitle() {
    }

    @Test
    public void getByAuthor() {
    }

    @Test
    public void getByYear() {
    }

    @Test
    public void createBookFrom() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void free() {
    }
}