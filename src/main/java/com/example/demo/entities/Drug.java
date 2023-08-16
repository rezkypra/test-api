package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer stock;
    private Integer price;

    @OneToMany(mappedBy = "drug")
    @JsonIgnore
    private List<CheckingDrug> checkingDrug;
    public Integer getid() {
        return id;
    }

    public void setDrug_id(Integer id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setDrug_name(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<CheckingDrug> getCheckingDrug() {
        return checkingDrug;
    }

    public void setCheckingDrug(List<CheckingDrug> checkingDrug) {
        this.checkingDrug = checkingDrug;
    }

}
    