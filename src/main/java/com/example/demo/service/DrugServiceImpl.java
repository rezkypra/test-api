package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Drug;
import com.example.demo.repositories.DrugRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugRepository drugRepository;

    @Override
    public List<Drug> Get() {
        return drugRepository.findAll();
    }

    @Override
    public Drug Get(Integer id) {
        return drugRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Drug model) {
        drugRepository.save(model);
        return drugRepository.findById(model.getDrug_id()).isPresent();
    }


    @Override
    public Boolean Delete(Integer id) {
        drugRepository.deleteById(id);
        return !drugRepository.findById(id).isPresent();
    }

    
}
