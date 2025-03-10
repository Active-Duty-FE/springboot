package com.msb.controller;

import com.msb.pojo.Clazz;
import com.msb.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping("/clazz")
    List<Clazz> getAllClazz() {
        return clazzService.getAllClazz();
    }
}
