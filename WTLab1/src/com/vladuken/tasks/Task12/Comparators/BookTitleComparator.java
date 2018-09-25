package com.vladuken.tasks.Task12.Comparators;

import com.vladuken.tasks.Task12.unit.Book;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

    public int compare(Book a, Book b){
        return a.getTitle().compareTo(b.getTitle());
    }
}
