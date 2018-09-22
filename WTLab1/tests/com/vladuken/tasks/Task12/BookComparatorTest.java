package com.vladuken.tasks.Task12;

import com.vladuken.tasks.Task12.Comparators.BookAuthorComparator;
import com.vladuken.tasks.Task12.Comparators.BookPriceComparator;
import com.vladuken.tasks.Task12.Comparators.BookTitleComparator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

public class BookComparatorTest {

    Book book1 = new Book("Little Prince","Antoine de Saint-Exupery",9,747282);
    Book book2 = new Book("Little Prince","Antoine de Saint-Exupery",10,747282);
    Book book3 = new Book("Hiperion","Dan Simmons", 20, 123421);
    Book book4 = new Book("Witcher","Anjei Sapkovsky", 15,414324);
    Book book5 = new Book("Hiperion","Dan Cimmons", 19, 123421);
    Book book6 = new Book("Witcher","Anjei Sapkovsky", 10,414324);

    Book[] bookArray = new Book[]{book1,book2,book3,book4,book5,book6};

    @Test
    public void testCompareByAuthor() {
        Comparator<Book> authorComparator = new BookAuthorComparator();

        Arrays.sort(bookArray,authorComparator);
        System.out.println("By Author:");
        printBookArray(bookArray);
    }

    @Test
    public void testCompareByTitle() {
        Comparator<Book> titleComparator = new BookTitleComparator();

        Arrays.sort(bookArray,titleComparator);
        System.out.println("By Title :");
        printBookArray(bookArray);
    }

    @Test
    public void testCompareByAuthorThenTitle() {
        Comparator<Book> authorThenTitleComparator = new BookAuthorComparator().thenComparing(new BookTitleComparator());
        Arrays.sort(bookArray,authorThenTitleComparator);
        System.out.println("By Author --> Title:");

        printBookArray(bookArray);
    }

    @Test
    public void testCompareByTitleThenAuthor() {
        Comparator<Book> titleThenAuthorComparator = new BookTitleComparator().thenComparing(new BookAuthorComparator());
        Arrays.sort(bookArray,titleThenAuthorComparator);
        System.out.println("By Title --> Author:");
        printBookArray(bookArray);
    }

    @Test
    public void testCompareByAuthorThenTitleThenPrice() {
        Comparator<Book> authorThenTitleThenPriceComparator = new BookAuthorComparator().thenComparing(new BookTitleComparator()).thenComparing(new BookPriceComparator());
        Arrays.sort(bookArray,authorThenTitleThenPriceComparator);
        System.out.println("By Author --> Title --> Price:");

        printBookArray(bookArray);
    }

    public void printBookArray(Book[] bookArray){

        for(Book book:bookArray){
            System.out.println(book);

        }

        System.out.println("\n");
    }
}