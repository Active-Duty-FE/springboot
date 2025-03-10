package com.msb.mapper;

import com.msb.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getAllStudent();
    int createStudent(Student student);
}
