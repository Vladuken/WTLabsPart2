package com.vladuken.tasks.Task12;

public class ProgrammerBook extends Book{

    private String language;
    private Integer level;

    public ProgrammerBook(String title, String author, Integer price,String language, Integer level){
        super(title, author, price);
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

}
