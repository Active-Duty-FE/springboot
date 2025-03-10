package com.msb.service;

import com.msb.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    int createStudent(Student student);
}
