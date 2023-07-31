package com.example.s11.service;

import com.example.s11.model.Books;
import com.example.s11.repository.BookRepository;
import com.example.s11.repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService{
    private IBookRepository bookRepository = new BookRepository();
    @Override
    public List<Books> getAll() {
        List<Books> booksList = bookRepository.getAll();
        return booksList;
    }

    @Override
    public void save(Books books) {
    bookRepository.save(books);
    }

    @Override
    public Books getBookId(int idBook) {
        return bookRepository.findById(idBook);
    }

    @Override
    public void updateBook(Books books) {
        bookRepository.saveBook(books);

    }

    @Override
    public void remove(int id) {
        bookRepository.remove(id);
    }
}
