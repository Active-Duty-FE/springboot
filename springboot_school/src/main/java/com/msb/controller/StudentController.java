package com.msb.controller;

import com.msb.pojo.Student;
import com.msb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/student")
    public int createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
