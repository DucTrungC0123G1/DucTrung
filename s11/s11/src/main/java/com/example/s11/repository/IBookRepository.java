package com.example.s11.repository;

import com.example.s11.model.Books;

import java.util.List;

public interface IBookRepository {
    List<Books> getAll();

    void save(Books books);

    Books findById(int idBook);

    boolean saveBook(Books books);

    boolean remove(int id);
}
