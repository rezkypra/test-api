package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserService userService;
    
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean register(RegisterRequest registerRequest) {
        Employee employee = new Employee();
        employee.setEmail(registerRequest.getEmail());
        employee.setName(registerRequest.getName());

        boolean resultEmployee = employeeService.Save(employee);
        if(resultEmployee) {
            Integer id = employeeService.findIdByEmail(registerRequest.getEmail());
            Login login = new Login();
            login.setId(id);
            login.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            boolean resultUser = userService.Save(login);
            return resultUser;
        }
        return resultEmployee;
    }
    
}
