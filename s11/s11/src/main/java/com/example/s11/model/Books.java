package com.example.s11.model;

public class Books {
    private int idBook;
    private String titleBook;
    private int pageSize;
    private String category;
    private String author;

    public Books() {
    }

    public Books(int idBook, String titleBook, int pageSize, String category, String author) {
        this.idBook = idBook;
        this.titleBook = titleBook;
        this.pageSize = pageSize;
        this.category = category;
        this.author = author;

    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
