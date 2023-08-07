package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.service.DrugService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Drug {

    @Autowired
    private DrugService drugService;

	@Test
	public void Save() {
        Boolean expected = true;
        com.example.demo.entities.Drug drug = new com.example.demo.entities.Drug();
        drug.setDrug_id(3);
        drug.setDrug_name("Panadol");
        drug.setStock(7);
        drug.setPrice(3000);

        Boolean result = drugService.Save(drug);

        assertEquals(expected, result);
	}
    @Test
	public void Delete() {
        Boolean expected = true;
        Integer drugId = 7;

        Boolean result = drugService.Delete(drugId);

        assertEquals(expected, result);
    }
}
