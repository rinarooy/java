package com.example.demo.controllers;

import com.example.demo.model.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/auth")
    public String thyTest(Model model){
        String msg = "кто-то";
        model.addAttribute("message", msg);
        String[] allq = {"q1", "q2", "q3"};
        model.addAttribute("allq", allq);
        MyUser myUser = new MyUser();
        model.addAttribute("myUser", myUser);
        return "auth";
    }
}
