package com.vladuken.tasks.Task12.unit;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BookCollection {
    private LinkedList<Book> bookList = new LinkedList<>();

    public BookCollection(){

    }
    public BookCollection(Book book){
        this.add(book);
    }
    public BookCollection(Book... books){
        for(Book book:books){
            this.add(book);
        }
    }

    public boolean isEmpty(){
        return bookList.isEmpty();
    }

    public void add(Book book){
        bookList.add(book);
    }

    public void add(Book... books){
        for(Book book:books){
            bookList.add(book);
        }
    }

    public void add(List<Book> books){
        for(Book book:books){
            bookList.add(book);
        }
    }

    public Book getFirst(){
        return bookList.getFirst();
    }

    public Book getLast(){
        return bookList.getFirst();
    }

    public Book removeFirst(){
        return bookList.removeFirst();
    }

    public Book removeLast(){
        return bookList.removeLast();
    }

    public void sortBy(Comparator<Book> bookComparator){
        bookList.sort(bookComparator);
    }

    public Book getByIsbn(Integer isbn){
        for (Book book:bookList) {
            if (book.getIsbn() == isbn){
                return book;
            }
        }
        return null;
    }

    public void remove(Book book){
        bookList.remove(book);
    }
    public void removeByIsbn(Integer isbn){
        Book book = getByIsbn(isbn);
        if (book != null){
            bookList.remove();
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("");
        for(Book book: bookList){
            stringBuilder.append(book);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
