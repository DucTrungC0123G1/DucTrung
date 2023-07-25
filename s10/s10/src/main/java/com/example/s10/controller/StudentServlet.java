package com.example.s10.controller;

import com.example.s10.model.Student;
import com.example.s10.service.IStudentService;
import com.example.s10.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.getAll();
        if (studentList.size() == 0) {
            String mess = "Danh sách Rỗng";
            request.setAttribute("mess", mess);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/list.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("studentList", studentList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/list.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
