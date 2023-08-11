package com.example.demo.service;

import com.example.demo.entities.Employee;
import com.example.demo.service.generic.GenericService;

public interface EmployeeService extends GenericService<Employee, Integer> {

    public Integer findIdByEmail(String email);
}
