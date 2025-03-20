package com.msb.controller;

import com.github.pagehelper.PageInfo;
import com.msb.pojo.Student;
import com.msb.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name="student module", description = "for student request")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    @Operation(summary = "get all student")
    public PageInfo<Student> getAllStudent(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return studentService.getAllStudent(pageNum, pageSize);
    }

    @GetMapping(value = "/student/{id}")
    @Operation(summary = "유저 id 로 유저 정보 가져오기")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    @Operation(summary = "save student")
    public Student createStudent(@RequestBody @Valid Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/student")
    @Parameter(name="유저 삭제 ids", description = "유저 ids Array", required = true)
    @Operation(summary = "유저 아이디로 유저 삭제")
    public int deleteStudentByIds(@RequestBody List<Integer> ids){
        return studentService.deleteStudentById(ids);
    }

}
