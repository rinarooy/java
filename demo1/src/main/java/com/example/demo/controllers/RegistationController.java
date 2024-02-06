package com.example.demo.controllers;

import com.example.demo.model.MyUser;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RegistationController {
    @Autowired
    private static EmployeeRepository employeeRepository;
    @GetMapping("/")
    public String thyTest(Model model){
        String msg = "кто-то";
        model.addAttribute("message", msg);
        String[] allq = {"q1", "q2", "q3"};
        model.addAttribute("allq", allq);
        MyUser myUser = new MyUser();
        model.addAttribute("myUser", myUser);
        return "index";
    }
    @GetMapping("/Register")
    public String regUsers(Model model, @ModelAttribute MyUser employee){
        List<MyUser> users = createEmployee(employee);
        model.addAttribute("users", users);
        return "allUsers";
    }
    public List<MyUser> createEmployee(MyUser employee) {
        List<MyUser> users = employeeRepository.findAll();
        for (MyUser user : users){
            if (user.getLogin().equals(employee.getLogin())){
                return null;
            }
        }
        employeeRepository.save(employee);
        users = employeeRepository.findAll();
        return users;
    }
    /*@PostMapping("/")
    public String thyTestGet(Model model, @ModelAttribute MyUser myUser){
        System.out.println(myUser.getLogin() + " " + myUser.getPassword());
        return "index";
    }*/
}
