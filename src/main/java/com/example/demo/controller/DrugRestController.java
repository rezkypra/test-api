package com.example.demo.controller;

import com.example.demo.entities.Drug;
import com.example.demo.handler.Response;
import com.example.demo.service.DrugService;

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
public class DrugRestController {
    @Autowired
    private DrugService drugService;

    @GetMapping("drug")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "data has been added", drugService.Get());
    }

    @GetMapping("drug/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true)Integer id) {
        return Response.generate(HttpStatus.OK, "data has been added", drugService.Get());
    }

    @PostMapping("drug")
    public ResponseEntity<Object> save(@RequestBody Drug drug) {
        drugService.Save(drug);
        return Response.generate(HttpStatus.OK, "data has been added");
    }

    @DeleteMapping("drug/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true)Integer id) {
        drugService.Delete(id);
        return Response.generate(HttpStatus.OK, "data has been deleted");
    }
}