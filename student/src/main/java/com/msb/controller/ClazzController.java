package com.msb.controller;

import com.msb.pojo.Clazz;
import com.msb.service.ClazzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClazzController {

    private ClazzService clazzService;
    @GetMapping("/class")
    public List<Clazz> selectAllClazz() {
        return clazzService.selectAllClazz();
    }
    @PostMapping("/class")
    public String insertClazz(Clazz clazz) {
        String result="success";
        int i = clazzService.insertClazz(clazz);
        if(i < 0) {
            result="fail";
        }
        return result;
    }
    @PutMapping("/class")
    public String updateClazz(Clazz clazz) {
        String result="success";
        int i = clazzService.updateClazz(clazz);
        if(i < 0) {
            result="fail";
        }
        return result;
    }
}
