package com.vladuken.presentationlayer;


import com.vladuken.dao.BookDAO;
import com.vladuken.dao.UserDAO;
import com.vladuken.entity.Book;
import com.vladuken.entity.User;
import com.vladuken.exceptions.DAOException;
import com.vladuken.service.BookMySQLService;
import com.vladuken.service.UserMySQLService;
import com.vladuken.util.MD5;
import com.vladuken.util.scanner.Reader;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class ConsoleView {
    User loggedUser;
    UserDAO userService;
    BookDAO bookService;
    public ConsoleView() {
        userService = new UserMySQLService();
        bookService = new BookMySQLService();
    }

    public void main(){
        help();
        String command;
        while(true){
            command = Reader.readString().trim();

            switch (command){
                case "help":
                    help();
                    break;
                case "login":
                    if(loggedUser==null)
                        login();
                    else
                        System.out.println("User "+loggedUser.getEmail()+" is already logged\n" +
                                "Log out first");
                    break;
                case "register":
                    if(loggedUser==null){
                        register();
                    }else {
                        System.out.println("User "+loggedUser.getEmail()+" is already logged\n" +
                                "To register Log out first");
                    }
                    break;

                case "add":
                    if(loggedUser==null){
                        System.out.println("Log in first");
                    }else if(isAdmin(loggedUser)){
                        add();
                    }else {
                        System.out.println("User " + loggedUser.getEmail() + " is not admin to add\n");
                    }
                    break;
                case "update":
                    if(loggedUser==null){
                        System.out.println("Log in first");
                    }else if(isAdmin(loggedUser)){
                        update();
                    }else {
                        System.out.println("User " + loggedUser.getEmail() + " is not admin to update\n");
                    }
                    break;
                case "delete":
                    if(loggedUser==null){
                        System.out.println("Log in first");
                    }else if(isAdmin(loggedUser)){
                        delete();
                    }else {
                        System.out.println("User " + loggedUser.getEmail() + " is not admin to delete\n");
                    }
                    break;

                case "show":
                    if(loggedUser==null){
                        System.out.println("Log in first");
                    }else{
                        show();
                    }
                    break;

                case "tsearch":
                    if(loggedUser==null){
                        System.out.println("Log in first");
                    }else{
                        tsearch();
                    }
                    break;
                case "asearch":
                    if(loggedUser==null){
                        System.out.println("Log in first");
                    }else{
                        asearch();
                    }
                    break;
                case "ysearch":
                    if(loggedUser==null){
                        System.out.println("Log in first");
                    }else{
                        ysearch();
                    }

                    break;
                case "logout":
                    if(loggedUser==null){
                        System.out.println("Log in first");
                    }else{
                        loggedUser=null;
                        System.out.println("Successful logout");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void help(){
        String help ="------------------------------------------\n";
        help +=
                "help - show help\n" +
                "login - log in\n" +
                "register - register user\n" +
                "Admin:\n" +
                    "\tadd - add book\n" +
                    "\tdelete - delete book\n" +
                    "\tupdate - update book by id\n" +
                "show - print books (by pages)\n" +
                "asearch - search books by author\n" +
                "tsearch - search books by title\n" +
                "ysearch - search books by year\n" +
                "logout - log out\n";
        help +="------------------------------------------";

        System.out.println(help);
    }

    private void login(){
        System.out.println("Enter email");
        String email = Reader.readString();
        System.out.println("Enter password");
        String password = Reader.readString();

        try{
            loginWith(email,password);
        }catch (DAOException e){
            System.out.println(e.getMessage());
        }
    }

    private void loginWith(String email,String password) throws DAOException {
        User user;
        try {
            user = userService.getByEmail(email);

        } catch (DAOException e) {
            throw new DAOException("Login error", e);
        }

        if (!user.getPassword().equals(MD5.getMD5(password))) {
            throw new DAOException("Login error: wrong password");
        } else {
            loggedUser = user;
            System.out.println("Success login");
        }
    }

    private void register(){
        System.out.println("Enter email");
        String email = Reader.readString();
        System.out.println("Enter password");
        String password = Reader.readString();
        System.out.println("Enter password again");
        String passwordcopy = Reader.readString();
        System.out.println("Enter state ('admin' for admin, anything other to default user)");
        String status = Reader.readString();
        if(!status.equals("admin")){
            status = "user";
        }

        if(password.equals(passwordcopy)){
            try{
                registerWith(email,password,status);
            }catch (DAOException e){
                System.out.println(e.getMessage());
            }
        }else
        {
            System.out.println("Entered passwords are not equal");
        }

    }

    private void registerWith(String email,String password,String status)throws DAOException{
        User user = new User();
        user.setEmail(email);
        user.setPassword(MD5.getMD5(password));
        user.setStatus(status);
        try{
            userService.add(user);
        }catch (DAOException e){
            throw new DAOException("Register user error",e);
        }

        System.out.println("Success registration");
    }

    private boolean isAdmin(User user){
        if(user.getStatus() != null){
            if(user.getStatus().equals("admin"))
                return true;
            else
                return false;
        }else
            return false;
    }

    private void add(){
        Book book = inputBook();
        try{
            bookService.add(book);
            System.out.println("Book added");
        }catch (DAOException e){
            System.out.println(e.getMessage());
        }
    }


    private void update(){
        System.out.println("Enter id of book to change");
        Integer id = Reader.readInt();

        try{
            Book book;
            Book newBook;
            try {
                book = bookService.getById(id);
                newBook = inputBook();
                newBook.setId(book.getId());

            }catch (DAOException e){
                throw new DAOException("No book with such id",e);
            }

            try{
                bookService.update(newBook);
                System.out.println("Book updated");
            }catch (DAOException e){
                System.out.println(e.getMessage());
            }

        }catch (DAOException e){
            System.out.println(e.getMessage());
        }

    }

    private void delete(){
        System.out.println("Enter id");
        Integer id = Reader.readInt();
        try{
            Book book = bookService.getById(id);
            bookService.delete(book);
            System.out.println("Book deleted");
        }catch (DAOException e){
            System.out.println("No book to delete");
        }
    }

    private Book inputBook(){
        System.out.println("Enter Title");
        String title = Reader.readString();
        System.out.println("Enter Author");
        String author = Reader.readString();
        System.out.println("Enter Year");
        Integer year = Reader.readInt();
        System.out.println("Enter type(1 to paperbook,2 to ebook,3 to audiobook (anything else to paperbook))");
        String type = Reader.readString();
        if(type.trim().equals("1")){
            type = "paperbook";
        }else if(type.trim().equals("2")){
            type = "ebook";
        }else if(type.trim().equals("3")){
            type = "audiobook";
        }else{
            type = "paperbook";
        }
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        book.setType(type);
        return book;
    }

    public void show(){
        int pageSize = 5;
        int bookCount;
        int pageid;

        try {
            bookCount = bookService.getAll().size();

            System.out.println("Enter page from " + 0 + " to " + bookCount/pageSize);
            pageid = Reader.readInt();

            List<Book> bookList = bookService.getByPage(pageid,pageSize);

            for (Book book: bookList) {
                System.out.println(book);
            }

        }catch (DAOException e){
            System.out.println(e.getMessage());
        }

    }

    private void tsearch(){
        System.out.println("Input title");
        String title = Reader.readString();
        try{
            List<Book> bookList = bookService.getAll();
            if(bookList.stream().filter((i)->i.getTitle().equals(title)).toArray().length==0)
                System.out.println("No books found");
            for (Book book:bookList){
                if(book.getTitle().equals(title))
                    System.out.println(book);

            }
        }catch (DAOException e){
            System.out.println(e.getMessage());
        }

    }


    private void asearch(){
        System.out.println("Input author");
        String author = Reader.readString();
        try{
            List<Book> bookList = bookService.getAll();
            if(bookList.stream().filter((i)->i.getAuthor().equals(author)).toArray().length==0)
                System.out.println("No books found");
            for (Book book:bookList){
                if(book.getAuthor().equals(author))
                    System.out.println(book);
            }
        }catch (DAOException e){
            System.out.println(e.getMessage());
        }

    }

    private void ysearch(){
        System.out.println("Input year");
        int year = Reader.readInt();
        try{
            List<Book> bookList = bookService.getAll();
            if(bookList.stream().filter((i)->i.getYear()==year).toArray().length==0)
                System.out.println("No books found");
            for (Book book:bookList){
                if(book.getYear() == year)
                    System.out.println(book);
            }
        }catch (DAOException e){
            System.out.println(e.getMessage());
        }

    }

}
