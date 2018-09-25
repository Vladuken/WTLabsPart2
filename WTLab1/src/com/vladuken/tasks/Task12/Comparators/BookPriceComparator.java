package com.vladuken.tasks.Task12.Comparators;

import com.vladuken.tasks.Task12.unit.Book;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {

    public int compare(Book a, Book b){
        return b.getPrice() - a.getPrice();
    }
}
