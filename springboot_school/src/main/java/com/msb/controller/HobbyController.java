package com.msb.controller;

import com.msb.pojo.Hobby;
import com.msb.service.HobbyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name="hobby module", description = "for student request")
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;
    @GetMapping("/hobby")
    public List<Hobby> getAllHobby(){
        return hobbyService.getAllHobby();
    }
}
