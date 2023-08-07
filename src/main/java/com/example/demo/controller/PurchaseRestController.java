package com.example.demo.controller;

import com.example.demo.entities.Purchase;
import com.example.demo.handler.Response;
import com.example.demo.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PurchaseRestController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("purchase")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "data has been added", purchaseService.Get());
    }

    @GetMapping("purchase/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true)Integer id) {
        return Response.generate(HttpStatus.OK, "data has been added", purchaseService.Get());
    }

    @PostMapping("purchase")
    public ResponseEntity<Object> save(@RequestBody Purchase purchase) {
        purchaseService.Save(purchase);
        return Response.generate(HttpStatus.OK, "data has been added");
    }

    @DeleteMapping("purchase/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true)Integer id) {
        purchaseService.Delete(id);
        return Response.generate(HttpStatus.OK, "data has been deleted");
    }
}