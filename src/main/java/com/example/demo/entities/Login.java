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
   private Integer login_id;
   public Integer getLogin_id() {
    return login_id;
}

public void setLogin_id(Integer login_id) {
    this.login_id = login_id;
}

private String login_username;
   public String getLoginUsername() {
    return login_username;
}

public void setLoginUsername(String login_username) {
    this.login_username = login_username;
}

   @ManyToOne
   @JoinColumn(name = "role_id")
   private Role role;

   @OneToOne
   @JoinColumn(name = "login_id")
   private Employee employee;


public String getLoginPassword() {
    return login_password;
}

public void setLoginPassword(String login_password) {
    this.login_password = login_password;
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

private String login_password;
}
