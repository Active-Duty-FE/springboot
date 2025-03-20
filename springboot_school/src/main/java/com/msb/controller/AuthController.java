package com.msb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest req) {
        if(username.equals("admin") && password.equals("123456")) {
            req.getSession().setAttribute("username", username);
            return "redirect:/mypage";
        }
        return "redirect:/login.html";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        req.getSession().removeAttribute("username");
        return "redirect:/login.html";
    }
}
