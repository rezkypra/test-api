package com.example.demo.controller;

import com.example.demo.entities.CheckingDrug;
import com.example.demo.service.CheckingDrugService;
import com.example.demo.service.DrugService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("checkingdrug")
public class CheckingDrugController {
    @Autowired
    private CheckingDrugService checkingDrugService;

    @Autowired
    private DrugService drugService;

    @GetMapping
    public String index(Model model) {  
        model.addAttribute("checkingdrugs", checkingDrugService.Get());
        return "checkingdrug/index";
    }

    @GetMapping(value = {"form", "form/{checkingDrug_id}"})
    public String form(Model model, @PathVariable(required = false) Integer checkingDrug_id) {
        if (checkingDrug_id != null) {
            model.addAttribute("drugs", drugService.Get());
            model.addAttribute("checkingdrug", checkingDrugService.Get(checkingDrug_id));
        } else {
            model.addAttribute("checkingdrug", new CheckingDrug());
        }
        return "checkingdrug/form";
    }

    @PostMapping("save")
    public String submit (CheckingDrug checkingDrug) {
        Boolean result = checkingDrugService.Save(checkingDrug);
        if (result) {
            return "redirect:/checkingdrug";
        } else {
            return "checkingdrug/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        checkingDrugService.Delete(id);
        return "redirect:/checkingdrug";
    }
}
