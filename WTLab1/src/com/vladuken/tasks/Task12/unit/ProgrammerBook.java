package com.vladuken.tasks.Task12.unit;

public class ProgrammerBook extends Book {

    private String language;
    private Integer level;

    public ProgrammerBook(String title, String author, Integer price,Integer isbn,String language, Integer level){
        super(title, author, price,isbn);
        this.language = language;
        this.level = level;
    }

    @Override
    public boolean equals(Object other){
        if(super.equals(other)){
           ProgrammerBook book = (ProgrammerBook) other;
           if(!this.language.equals(book.language)) return false;
           if (!(this.level == book.level)) return false;

        }
        return true;
    }

    @Override
    public Book clone(){
        String copyTitle = new String(getTitle());
        String copyAuthor = new String(getAuthor());
        Integer copyPrice = new Integer(getPrice());
        Integer copyIsbn = new Integer(getIsbn());
        String copyLanguage = new String(language);
        Integer copyLevel = new Integer(level);
        return new ProgrammerBook(copyTitle,copyAuthor,copyPrice,copyIsbn,copyLanguage,copyLevel);
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.language + " " + this.level;
    }

}
