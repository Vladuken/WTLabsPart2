package com.vladuken.tasks.Task12.server;

import com.vladuken.tasks.Task12.Comparators.BookTitleComparator;
import com.vladuken.tasks.Task12.unit.Book;
import com.vladuken.tasks.Task12.unit.BookCollection;
import com.vladuken.tasks.Task12.unit.ProgrammerBook;

import java.util.LinkedList;

public class Server {
    public static void main(String[] args){
        Book book1 = new Book("Little Prince","Antoine de Saint-Exupery",10,747282);
        Book book2 = new Book("Hiperion","Dan Simmons", 20, 123421);
        Book book3 = new Book("Witcher","Anjei Sapkovsky", 15,414324);
        Book book4 = new Book("The Three-Body Problem", "Liu Cixin",12,546232);

        BookCollection bookCollection = new BookCollection();
        bookCollection.add(book1);
        bookCollection.add(new Book[]{book2,book4,book3});
        System.out.println("Bookcollection: ");
        System.out.println(bookCollection);

        bookCollection.sortBy(new BookTitleComparator());
        System.out.println("Bookcollection (sorted by Title): \n");
        System.out.println(bookCollection);


        Book newbook = new ProgrammerBook("Hiperion","Dan Simmons", 15, 123421,"Java",5);
        bookCollection.add(newbook);

        System.out.println("Bookcollection (sorted by Title then by price): \n");
        bookCollection.sortBy(new BookTitleComparator());
        System.out.println(bookCollection);
        bookCollection.remove(newbook);

        while (!bookCollection.isEmpty()){
            bookCollection.removeFirst();
        }

        System.out.println("Empty bookcollection:");
        System.out.println(bookCollection);
    }

}
