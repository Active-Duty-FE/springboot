package com.msb.mapper;

import com.msb.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getAllStudent();
    Student getStudentById(Integer id);
    void createStudent(Student student);
    int deleteStudentByIds(List<Integer> ids);
}
