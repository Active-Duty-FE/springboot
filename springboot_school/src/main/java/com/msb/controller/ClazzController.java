package com.msb.controller;

import com.msb.pojo.Clazz;
import com.msb.service.ClazzService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name="clazz module", description = "for student request")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping("/clazz")
    List<Clazz> getAllClazz() {
        return clazzService.getAllClazz();
    }
}
