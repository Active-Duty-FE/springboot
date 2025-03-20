package com.msb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msb.mapper.StudentMapper;
import com.msb.pojo.Student;
import com.msb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> getAllStudent(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentMapper.getAllStudent();
        PageInfo<Student> info = new PageInfo<>(students);
        return info;
    }

    @Override
    public Student createStudent(Student student) {
        studentMapper.createStudent(student);
        return studentMapper.getStudentById(student.getId());
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteStudentById(List<Integer> ids) {
        int i = studentMapper.deleteStudentByIds(ids);
//        int num = 1/0;
        return i;
    }
}
