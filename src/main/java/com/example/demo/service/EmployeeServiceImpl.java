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
    public Employee Get(Integer Id) {
        return employeeRepository.findById(Id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Employee model) {
        employeeRepository.save(model);
        return employeeRepository.findById(model.getId()).isPresent();
    }


    @Override
    public Boolean Delete(Integer Id) {
        employeeRepository.deleteById(Id);
        return !employeeRepository.findById(Id).isPresent();
    }

    @Override
    public Integer findIdByEmail(String email) {
        return employeeRepository.findIdByEmail(email);
    }

}