package com.vladuken.tasks.Task12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void compareTo() {

        Book book1 = new Book("Little Prince","Antoine de Saint-Exupery",10,747282);
        Book book2 = new Book("Hiperion","Dan Simmons", 20, 123421);
        Book book3 = new Book("Witcher","Anjei Sapkovsky", 15,414324);
        Book[] bookArray = new Book[]{book1,book2,book3};
        Arrays.sort(bookArray);
        assertArrayEquals(new Book[]{book2,book3,book1},bookArray);
    }
}