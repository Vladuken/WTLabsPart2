package com.vladuken.presentationlayer;

import com.vladuken.datalayer.MySQLConnection;
import com.vladuken.entity.Book;
import com.vladuken.service.BookService;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
	// write your code here
        MySQLConnection sql = new MySQLConnection();
        sql.getConnection();

        BookService bookService = new BookService();
        try{
            bookService.add(
                    new Book("TESTBOOK",1992,"Heminguay","paperbook")

            );
        }
        catch (SQLException e){
            System.out.println("Some error");
            //e.printStackTrace();
        }

    }
}
