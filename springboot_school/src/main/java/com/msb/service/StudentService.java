package com.msb.service;

import com.github.pagehelper.PageInfo;
import com.msb.pojo.Student;

import java.util.List;

public interface StudentService {
    PageInfo<Student> getAllStudent(Integer pageNum, Integer pageSize);
    Student createStudent(Student student)
            ;
    Student getStudentById(Integer id);
    int deleteStudentById(List<Integer> ids);
}
