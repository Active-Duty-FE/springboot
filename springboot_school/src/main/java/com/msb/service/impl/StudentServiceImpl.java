package com.msb.service.impl;

import com.msb.mapper.StudentMapper;
import com.msb.pojo.Student;
import com.msb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public int createStudent(Student student) {
        return studentMapper.createStudent(student);
    }
}
