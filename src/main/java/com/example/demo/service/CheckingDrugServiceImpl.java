package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.CheckingDrug;
import com.example.demo.repositories.CheckingDrugRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingDrugServiceImpl implements CheckingDrugService {
    @Autowired
    private CheckingDrugRepository checkingDrugRepository;

    @Override
    public List<CheckingDrug> Get() {
        return checkingDrugRepository.findAll();
    }

    @Override
    public CheckingDrug Get(Integer checkingId) {
        return checkingDrugRepository.findById(checkingId).orElseThrow(null);
    }

    @Override
    public Boolean Save(CheckingDrug model) {
        checkingDrugRepository.save(model);
        return checkingDrugRepository.findById(model.getCheckingDrugId()).isPresent();
    }


    @Override
    public Boolean Delete(Integer id) {
        checkingDrugRepository.deleteById(id);
        return !checkingDrugRepository.findById(id).isPresent();
    }

    
}
