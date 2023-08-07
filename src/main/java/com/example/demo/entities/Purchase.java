package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchase_id;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    @JsonIgnore
    private Drug drug;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "checkingDrug_id")
    @JsonIgnore
    private CheckingDrug checkingDrug;
    private int amountDrug;
    private int total;
    private String information;
    private Date purchaseDate;

    public int getPurchaseId() {
        return purchase_id;
    }

    public void setPurchaseId(int purchase_id) {
        this.purchase_id = purchase_id;
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

    public CheckingDrug getCheckingDrug() {
        return checkingDrug;
    }

    public void setCheckingDrug(CheckingDrug checkingDrug) {
        this.checkingDrug = checkingDrug;
    }

    public int getAmountDrug() {
        return amountDrug;
    }

    public void setAmountDrug(int amountDrug) {
        this.amountDrug = amountDrug;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setDrug(String string) {
    }

    public void setEmployee(String string) {
    }

    public void setCheckingDrug(String string) {
    }
    
}