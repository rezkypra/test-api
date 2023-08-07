package com.example.demo.controller;

import com.example.demo.entities.Drug;
import com.example.demo.service.DrugService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("drug")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping
    public String index(Model model) {  
        model.addAttribute("drugs", drugService.Get());
        return "drug/index";
    }

    @GetMapping(value = {"form", "form/{drug_id}"})
    public String form(Model model, @PathVariable(required = false) Integer drug_id) {
        if (drug_id != null) {
            model.addAttribute("drug", drugService.Get(drug_id));
        } else {
            model.addAttribute("drug", new Drug());
        }
        return "drug/form";
    }

    @PostMapping("save")
    public String submit (Drug drug) {
        Boolean result = drugService.Save(drug);
        if (result) {
            return "redirect:/drug";
        } else {
            return "drug/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        drugService.Delete(id);
        return "redirect:/drug";
    }
}
