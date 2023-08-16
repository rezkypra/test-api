package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_login")
public class Login {
   @Id
   private Integer id;
   public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

private String username;
   public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

   @ManyToOne
   @JoinColumn(name = "role_id")
   private Role role;

   @OneToOne
   @JoinColumn(name = "login_id")
   private Employee employee;


public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public Role getRole() {
    return role;
}

public void setRole(Role role) {
    this.role = role;
}

public Employee getEmployee() {
    return employee;
}

public void setEmployee(Employee employee) {
    this.employee = employee;
}

private String password;
}
