package com.fashion.toucan.controllers;

import com.fashion.toucan.entities.Clothes;
import com.fashion.toucan.entities.ClothesDeliveries;
import com.fashion.toucan.entities.Shoes;
import com.fashion.toucan.repositories.ClothesDeliveriesRepository;
import com.fashion.toucan.repositories.ClothesRepository;
import com.fashion.toucan.repositories.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClothesDeliveriesController {
    @Autowired
    private ClothesDeliveriesRepository clothesDeliveriesRepository;
    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired
    private ShoesRepository shoesRepository;

    @PostMapping("/addClothesDeliveries")
    public String addCourse(ClothesDeliveries clothesDeliveries){
        clothesDeliveriesRepository.save(clothesDeliveries);
        return "redirect:/displayClothesDeliveries";
    }

    @GetMapping("/displayClothesDeliveries")
    public String displayCourse(Model model) {
        model.addAttribute("allClothesDeliveries", clothesDeliveriesRepository.findAll());
        model.addAttribute("clothesList",clothesRepository.findAll());
        model.addAttribute("shoesList", shoesRepository.findAll());
        model.addAttribute("clothes", new Clothes());
        model.addAttribute("shoes", new Shoes());
        return "clothesdeliveries";
    }

    @GetMapping("/deleteclothesDeliveries/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        clothesDeliveriesRepository.deleteById(id);
        return "redirect:/displayClothesDeliveries";
    }

    @GetMapping("/updateclothesDeliveries/{id}")
    public String updateCourse(@PathVariable("id") Integer id, Model model) {
        ClothesDeliveries clothesDeliveries = clothesDeliveriesRepository.getById(id);
        model.addAttribute("shoeRepositoryList",clothesRepository.findAll());
        model.addAttribute("clothesDeliveries", clothesDeliveries);
        return "editclothesDeliveries";
    }
}
