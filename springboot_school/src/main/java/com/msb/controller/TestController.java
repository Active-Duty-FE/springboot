package com.msb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test1")
    @ResponseBody
    public String test1(){
        int i = 1 / 0;
        return "test1";
    }
}
