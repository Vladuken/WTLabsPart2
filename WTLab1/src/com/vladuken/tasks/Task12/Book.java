package com.vladuken.tasks.Task12;

public class Book implements Cloneable,Comparable<Book> {
    private String title;
    private String author;
    private Integer price;
    private static Integer edition;

    private Integer isbn;

    public Book(){}

    public Book(String title, String author, Integer price,Integer isbn){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public void setEdition(Integer edition){
        this.edition = edition;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public Integer getPrice(){
        return price;
    }
    public Integer getIsbn(){
        return isbn;
    }

    public boolean equals(Book book) {
        if (this.title.equals(book.title) && this.author.equals(book.author)
                && this.price == book.price){
            return true;
        } else{
            return false;
        }

    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Book))return false;

        Book book = (Book)other;

        if (!this.title.equals(book.title)) return false;
        if (!this.author.equals(book.author)) return false;
        if (!(this.price == book.price)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        String res = "" + this.title + this.author + this.price;
        return res.hashCode();
    }

    @Override
    public String toString(){
        return this.title +" "+ this.author + " " + this.price;
    }

    @Override
    public Book clone(){
        return new Book(title,author,price,isbn);
    }

    public int compareTo(Book book){
         return  this.isbn - book.isbn;
    }


}
