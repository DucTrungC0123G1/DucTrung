package com.example.s10.repository;

import com.example.s10.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements  IStudentRepository{
    public static final String SELECT_ALL = "select * from student;";
    @Override
    public List<Student> getAll() {
        Connection connection = BaseRepository.getConnection();
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_student");
                String nameStudent = resultSet.getString("name_student");
                boolean genderStudent = resultSet.getBoolean("gender");
                int scoreStudent = resultSet.getInt("score_student");
                studentList.add(new Student(id,nameStudent,genderStudent,scoreStudent));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }
}
