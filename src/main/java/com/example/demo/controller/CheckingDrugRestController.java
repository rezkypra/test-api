package com.example.demo.controller;

import com.example.demo.entities.CheckingDrug;
import com.example.demo.handler.Response;
import com.example.demo.service.CheckingDrugService;

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
public class CheckingDrugRestController {
    @Autowired
    private CheckingDrugService checkingDrugService;

    @GetMapping("checkingdrug")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "data has been added", checkingDrugService.Get());
    }

    @GetMapping("checkingdrug/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true)Integer id) {
        return Response.generate(HttpStatus.OK, "data has been added", checkingDrugService.Get());
    }

    @PostMapping("checkingdrug")
    public ResponseEntity<Object> save(@RequestBody CheckingDrug checkingDrug) {
        checkingDrugService.Save(checkingDrug);
        return Response.generate(HttpStatus.OK, "data has been added");
    }

    @DeleteMapping("checkingdrug/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true)Integer id) {
        checkingDrugService.Delete(id);
        return Response.generate(HttpStatus.OK, "data has been deleted");
    }
}