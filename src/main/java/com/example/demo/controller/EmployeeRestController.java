package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.handler.Response;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employee")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "data has been added", employeeService.Get());
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true)Integer id) {
        return Response.generate(HttpStatus.OK, "data has been added", employeeService.Get());
    }

    @PostMapping("employee")
    public ResponseEntity<Object> save(@RequestBody Employee employee) {
        employeeService.Save(employee);
        return Response.generate(HttpStatus.OK, "data has been added");
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true)Integer id) {
        employeeService.Delete(id);
        return Response.generate(HttpStatus.OK, "data has been deleted");
    }
}