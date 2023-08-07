package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.service.CheckingDrugService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CheckingDrug {

    @Autowired
    private CheckingDrugService checkingDrugService;

	@Test
	public void Save() {
        Boolean expected = true;
        com.example.demo.entities.CheckingDrug checkingDrug = new com.example.demo.entities.CheckingDrug();
        checkingDrug.setCheckingId(7);
        checkingDrug.setDrug("Panadol");
        checkingDrug.setEmployee("Doni");
        checkingDrug.setCheckingStatus("Approved");

        Boolean result = checkingDrugService.Save(checkingDrug);

        assertEquals(expected, result);
	}
    @Test
	public void Delete() {
        Boolean expected = true;
        Integer checkingDrugId = 7;

        Boolean result = checkingDrugService.Delete(checkingDrugId);

        assertEquals(expected, result);
    }
}
