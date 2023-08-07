package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Purchase;
import com.example.demo.repositories.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> Get() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase Get(Integer purchase_id) {
        return purchaseRepository.findById(purchase_id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Purchase model) {
        purchaseRepository.save(model);
        return purchaseRepository.findById(model.getPurchaseId()).isPresent();
    }


    @Override
    public Boolean Delete(Integer purchaseId) {
        purchaseRepository.deleteById(purchaseId);
        return !purchaseRepository.findById(purchaseId).isPresent();
    }

    
}
