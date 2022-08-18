package com.fashion.toucan.controllers;

import com.fashion.toucan.entities.Clothes;
import com.fashion.toucan.entities.Shoes;
import com.fashion.toucan.entities.ShoesDeliveries;
import com.fashion.toucan.repositories.ClothesRepository;
import com.fashion.toucan.repositories.ShoesDeliveriesRepository;
import com.fashion.toucan.repositories.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoesDeliveriesController {
    @Autowired
    private ShoesDeliveriesRepository shoesDeliveriesRepository;
    @Autowired
    private ShoesRepository shoesRepository;
    @Autowired
    private ClothesRepository clothesRepository;

    @PostMapping("/addShoesDeliveries")
    public String addCourse(ShoesDeliveries shoesDeliveries){
        shoesDeliveriesRepository.save(shoesDeliveries);
        return "redirect:/displayShoesDeliveries";
    }

    @GetMapping("/displayShoesDeliveries")
    public String displayCourse(Model model) {
        model.addAttribute("allShoesDeliveries", shoesDeliveriesRepository.findAll());
        model.addAttribute("shoesList",shoesRepository.findAll());
        model.addAttribute("clothesList",clothesRepository.findAll());
        model.addAttribute("clothes", new Clothes());
        model.addAttribute("shoes", new Shoes());
        return "shoesdeliveries";
    }

    @GetMapping("/deleteshoesDeliveries/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        shoesDeliveriesRepository.deleteById(id);
        return "redirect:/displayShoesDeliveries";
    }

    @GetMapping("/updateshoesDeliveries/{id}")
    public String updateCourse(@PathVariable("id") Integer id, Model model) {
        ShoesDeliveries shoesDeliveries = shoesDeliveriesRepository.getById(id);
        model.addAttribute("shoeRepositoryList",shoesRepository.findAll());
        model.addAttribute("shoesDeliveries", shoesDeliveries);
        return "editshoesDeliveries";
    }
}
