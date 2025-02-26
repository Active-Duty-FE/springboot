package com.msb.controller;

import com.msb.pojo.User;
import com.msb.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> selectAllUsers() {
        List<User> users = userService.selectAllUsers();
        for (User user : users) {
            System.out.println(user + "user");
        }

        return userService.selectAllUsers();
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        String result;
        int i = userService.addUser(user);
        if (i > 0) {
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestBody List<Integer> id) {
        String result = "failure";
        boolean allDeleted = true;
        for(int i : id) {
            int r = userService.deleteUserById(i);
            if (r < 0) {
                allDeleted = false;
            }
        }
        if (allDeleted) {
            result = "success";
        }
        return result;
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody User user) {
        String result;
        int i = userService.updateUser(user);
        if (i > 0) {
            return "success";
        } else {
            result = "fail";
        }
        return result;
    }
}
