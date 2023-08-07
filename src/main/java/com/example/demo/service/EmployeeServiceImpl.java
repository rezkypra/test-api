package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> Get() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee Get(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(null);
    }

    @Override
    public Boolean Save(Employee model) {
        employeeRepository.save(model);
        return employeeRepository.findById(model.getEmployeeId()).isPresent();
    }


    @Override
    public Boolean Delete(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        return !employeeRepository.findById(employeeId).isPresent();
    }

}