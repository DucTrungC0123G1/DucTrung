package com.example.s11.repository;

import com.example.s11.model.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    public static final String SELECT_ALL_BOOK = "select b.id_books,b.title,b.page_size,c.name_category,a.name_author\n" +
            "from books b\n" +
            "left join category c on b.id_category = c.id_category\n" +
            "left join author a on b.id_author = a.id_author;";
    public static final String INSERT_BOOK = " insert into books values (?,?,?,?,?); ";
    public static final String SELECT_BOOK_BY_ID = " select * from books where books.id_books = ?; ";
    public static final String UPDATE_BOOK_BY_ID = "update books b\n" +
            "join category c on b.id_category = c.id_category\n" +
            "join author a on b.id_author = a.id_author\n" +
            "set b.title = ?, b.page_size=?,b.id_category=?,b.id_author=?" +
            "where b.id_books = ?;";
    public static final String DELETE_BOOK_BY_ID = "delete from books where books.id_books = ? ;";

    @Override
    public List<Books> getAll() {
        Connection connection = BaseRepository.getConnection();
        List<Books> booksList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_books");
                String title = resultSet.getString("title");
                int pageSize = resultSet.getInt("page_size");
                String category = resultSet.getString("name_category");
                String author = resultSet.getString("name_author");
                booksList.add(new Books(id, title, pageSize, category, author));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return booksList;
    }

    @Override
    public void save(Books books) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK);
            preparedStatement.setInt(1, books.getIdBook());
            preparedStatement.setString(2, books.getTitleBook());
            preparedStatement.setInt(3, books.getPageSize());
            preparedStatement.setString(4, books.getCategory());
            preparedStatement.setString(5, books.getAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Books findById(int idBook) {
        Books books = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setInt(1, idBook);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                int pageSize = resultSet.getInt("page_size");
                String category = resultSet.getString("id_category");
                String author = resultSet.getString("id_author");
                books = new Books(idBook, title, pageSize, category, author);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return books;
    }

    @Override
    public boolean saveBook(Books books) {
        boolean rowUpdate;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_BY_ID);
            preparedStatement.setString(1, books.getTitleBook());
            preparedStatement.setInt(2, books.getPageSize());
            preparedStatement.setString(3, books.getCategory());
            preparedStatement.setString(4, books.getAuthor());
            preparedStatement.setInt(5, books.getIdBook());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowUpdate;

    }

    @Override
    public boolean remove(int id) {
        boolean rowDelete = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowDelete;
    }
}
