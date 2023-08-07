package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String index(Model model) {  
        model.addAttribute("employees", employeeService.Get());
        return "employee/index";
    }

    @GetMapping(value = {"form", "form/{employee_id}"})
    public String form(Model model, @PathVariable(required = false) Integer employee_id) {
        if (employee_id != null) {
            model.addAttribute("employee", employeeService.Get(employee_id));
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "employee/form";
    }

    @PostMapping("save")
    public String submit (Employee employee) {
        Boolean result = employeeService.Save(employee);
        if (result) {
            return "redirect:/employee";
        } else {
            return "employee/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        employeeService.Delete(id);
        return "redirect:/employee";
    }
}
