package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import com.example.demo.service.PurchaseService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Purchase {

    @Autowired
    private PurchaseService purchaseService;

	@Test
	public void Save() {
        Boolean expected = true;
        com.example.demo.entities.Purchase purchase = new com.example.demo.entities.Purchase();
        purchase.setPurchaseId(7);
        purchase.setDrug("Panadol");
        purchase.setEmployee("Doni");
        purchase.setCheckingDrug("Approved");
        purchase.setAmountDrug(10);
        purchase.setTotal(30000);
        purchase.setInformation("Lunas");
        purchase.setPurchaseDate(DateFormat(23-01-2023));

        Boolean result = purchaseService.Save(purchase);

        assertEquals(expected, result);
	}
    private Date DateFormat(int i) {
        return null;
    }
    @Test
	public void Delete() {
        Boolean expected = true;
        Integer purchaseId = 7;

        Boolean result = purchaseService.Delete(purchaseId);

        assertEquals(expected, result);
    }
}
