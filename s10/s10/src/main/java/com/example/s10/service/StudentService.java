package com.example.s10.service;

import com.example.s10.model.Student;
import com.example.s10.repository.IStudentRepository;
import com.example.s10.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAll() {
        List<Student> studentList = studentRepository.getAll();
        return studentList;
    }
}
