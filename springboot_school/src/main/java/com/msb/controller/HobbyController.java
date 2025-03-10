package com.msb.controller;

import com.msb.pojo.Hobby;
import com.msb.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;
    @GetMapping("/hobby")
    public List<Hobby> getAllHobby(){
        return hobbyService.getAllHobby();
    }
}
