package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Drug;



@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer>
{
    
}
