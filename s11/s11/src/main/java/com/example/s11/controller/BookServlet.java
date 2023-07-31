package com.example.s11.controller;

import com.example.s11.model.Books;
import com.example.s11.service.BookService;
import com.example.s11.service.IBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showFormCreate":
                showFormCreate(request, response);
                break;
            case "showFormEdit":
                showFormEdit(request, response);
                break;
            case "deleteBook":
                deleteBook(request,response);
            default:
                showListBook(request, response);
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.remove(id);
        request.setAttribute("msg",id);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/BookServlet?action=");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int idBook = Integer.parseInt(request.getParameter("id"));
        Books books = bookService.getBookId(idBook);
//        request.setAttribute("idBook", idBook);
        request.setAttribute("books", books);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_manager/editbook.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_manager/addbook.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListBook(HttpServletRequest request, HttpServletResponse response) {
        List<Books> booksList = bookService.getAll();
        request.setAttribute("booksList", booksList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_manager/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addBook":
                addBook(request, response);
                break;
            case "editBook":
                editBook(request, response);
                break;

        }
    }



    private void editBook(HttpServletRequest request, HttpServletResponse response) {
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String title = request.getParameter("title");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String category = request.getParameter("category");
        String author = request.getParameter("author");
        Books books = new Books(idBook,title,pageSize,category,author);
        bookService.updateBook(books);
        try {
            response.sendRedirect("/BookServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) {
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String titleBook = request.getParameter("titleBook");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String category = request.getParameter("category");
        String author = request.getParameter("author");
        Books books = new Books(idBook, titleBook, pageSize, category, author);
        bookService.save(books);
        try {
            response.sendRedirect("/BookServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
