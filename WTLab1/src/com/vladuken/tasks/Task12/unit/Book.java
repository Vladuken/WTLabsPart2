package com.vladuken.tasks.Task12.unit;

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
        String res = this.toString();

        int hash = 7;
        for (int i = 0; i < res.length(); i++) {
            hash = hash*31 + res.charAt(i);
        }

        return hash;
    }

    @Override
    public String toString(){
        return this.title +" "+ this.author + " " + this.price;
    }

    @Override
    public Book clone(){
        String copyTitle = new String(title);
        String copyAuthor = new String(author);
        Integer copyPrice = new Integer(price);
        Integer copyIsbn = new Integer(isbn);
        return new Book(copyTitle,copyAuthor,copyPrice,copyIsbn);
    }

    public int compareTo(Book book){
         return  this.isbn - book.isbn;
    }


}
