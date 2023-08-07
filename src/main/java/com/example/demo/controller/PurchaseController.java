package com.example.demo.controller;

import com.example.demo.entities.Purchase;
import com.example.demo.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public String index(Model model) {  
        model.addAttribute("purchases", purchaseService.Get());
        return "purchase/index";
    }

    @GetMapping(value = {"form", "form/{purchase_id}"})
    public String form(Model model, @PathVariable(required = false) Integer purchase_id) {
        if (purchase_id != null) {
            model.addAttribute("purchase", purchaseService.Get(purchase_id));
        } else {
            model.addAttribute("purchase", new Purchase());
        }
        return "purchase/form";
    }

    @PostMapping("save")
    public String submit (Purchase purchase) {
        Boolean result = purchaseService.Save(purchase);
        if (result) {
            return "redirect:/purchase";
        } else {
            return "purchase/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        purchaseService.Delete(id);
        return "redirect:/purchase";
    }
}
