package com.example.s10.model;

public class Student {
    private int idStudent;
    private String nameStudent;
    private boolean genderStudent;
    private int scoreStudent;

    public Student() {
    }

    public Student(int idStudent, String nameStudent, boolean genderStudent, int scoreStudent) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.genderStudent = genderStudent;
        this.scoreStudent = scoreStudent;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public boolean isGenderStudent() {
        return genderStudent;
    }

    public void setGenderStudent(boolean genderStudent) {
        this.genderStudent = genderStudent;
    }

    public int getScoreStudent() {
        return scoreStudent;
    }

    public void setScoreStudent(int scoreStudent) {
        this.scoreStudent = scoreStudent;
    }
}
