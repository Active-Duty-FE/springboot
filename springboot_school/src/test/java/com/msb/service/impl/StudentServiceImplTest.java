package com.msb.service.impl;

import com.github.pagehelper.PageInfo;
import com.msb.mapper.StudentMapper;
import com.msb.pojo.Student;
import com.msb.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
@SpringBootTest
class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @Test
    void getAllStudent() {
        PageInfo<Student> students = studentService.getAllStudent(1, 10);

    }

    @Test
    void createStudent() {
    }

    @Test
    void getStudentById() {
    }

    @Test
    void deleteStudentById() {
    }
}