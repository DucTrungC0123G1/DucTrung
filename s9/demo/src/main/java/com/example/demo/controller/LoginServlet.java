package com.example.demo.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action ==null){
        action  = "";
    }
    switch (action){
        default:
            showFormLogin(request,response);
    }
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
        try {
            requestDispatcher.forward(request,response);
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
        switch (action){
            default:
                loginForm(request,response);
        }
    }

    private void loginForm(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        if (userName.equals("admin")&&password.equals("123abc")){
            try {
                response.sendRedirect("login/success.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                response.sendRedirect("login/error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
