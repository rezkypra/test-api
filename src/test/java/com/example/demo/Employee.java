package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Employee {

    @Autowired
    private EmployeeService employeeService;

	@Test
	public void Save() {
        Boolean expected = true;
        com.example.demo.entities.Employee employee = new com.example.demo.entities.Employee();
        employee.setId(2);
        employee.setName("Deni");
        employee.setAddress("Jl Karbela");
        employee.setPhone("083648136812");
        employee.setEmail("denysiregar33@gmail.com");

        Boolean result = employeeService.Save(employee);

        assertEquals(expected, result);
	}

    @Test
	public void Delete() {
        Boolean expected = true;
        Integer employeeId = 7;

        Boolean result = employeeService.Delete(employeeId);

        assertEquals(expected, result);
    }
}