package org.example;

public class Book {
    private String name;
    private String author;
    private int bookid;

    public Book(String name, String author, int bookid) {
        this.name = name;
        this.author = author;
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
}
