package com.vladuken.tasks.Task12.Comparators;

import com.vladuken.tasks.Task12.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

    public int compare(Book a, Book b){
        return a.getAuthor().compareTo(b.getAuthor());
    }
}
