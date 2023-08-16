package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT l FROM Login l JOIN l.employee e WHERE e.email = ?1")
    public Login login(String email);
    // public Boolean register();
}
