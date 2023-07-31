package com.example.s11.service;

import com.example.s11.model.Books;

import java.util.List;

public interface IBookService {
    List<Books> getAll();

    void save(Books books);

    Books getBookId(int idBook);

    void updateBook(Books books);

    void remove(int id);
}
