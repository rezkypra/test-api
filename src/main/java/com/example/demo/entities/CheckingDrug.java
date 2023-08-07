package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_checkingDrug")
public class CheckingDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int checkingDrug_id;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    @JsonIgnore
    private Drug drug;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    private String checkingStatus;

    public int getCheckingDrugId() {
        return checkingDrug_id;
    }

    public void setCheckingId(int checkingDrug_id) {
        this.checkingDrug_id = checkingDrug_id;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCheckingStatus() {
        return checkingStatus;
    }

    public void setCheckingStatus(String checkingStatus) {
        this.checkingStatus = checkingStatus;
    }

    public void setEmployee(String string) {
    }

    public void setDrug(String string) {
    }
    
}