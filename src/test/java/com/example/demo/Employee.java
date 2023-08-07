package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

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
        employee.setEmployeeId(2);
        employee.setEmployeeName("Deni");
        employee.setEmployeeAddress("Jl Karbela");
        employee.setEmployeePhone("083648136812");
        employee.setEmployeeEmail("denysiregar33@gmail.com");
        Date employeeJoinDate = Date.valueOf("2023-08-07");
        employee.setEmployeeJoinDate(employeeJoinDate);

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