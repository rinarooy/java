package com.example.demo.controllers;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MyUser;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/api/v1/")
@Controller
@RequestMapping
public class ThyTestController {
    @Autowired
    private static EmployeeRepository employeeRepository;

    // get all employees
    @GetMapping("/ThyTest")
    public List<MyUser> getAllEmployees(){
        return employeeRepository.findAll();
    }
    // create employee rest api
    @GetMapping("/Reg")
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

    @GetMapping("/Auth")
    public List<MyUser> auth(MyUser employee) {
        List<MyUser> users = employeeRepository.findAll();
        for (MyUser user : users){
            if (user.getLogin().equals(employee.getLogin())){
                users = employeeRepository.findAll();
                return users;
            }
        }
        return null;
    }

    // get employee by id rest api
    //@GetMapping("/ThyTest/{id}")
    public ResponseEntity<MyUser> getEmployeeById(@PathVariable Long id) {
        MyUser employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }
    // update employee rest api

    //@PutMapping("/ThyTest/{id}")
    public ResponseEntity<MyUser> updateEmployee(@PathVariable Long id, @RequestBody MyUser employeeDetails){
        MyUser employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setLogin(employeeDetails.getLogin());
        employee.setPassword(employeeDetails.getPassword());

        MyUser updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    // delete employee rest api
    //@DeleteMapping("/ThyTest/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        MyUser employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
