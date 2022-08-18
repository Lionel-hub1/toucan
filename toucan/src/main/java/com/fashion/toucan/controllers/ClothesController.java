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
public class ClothesController {
    @Autowired
    ClothesRepository clothesRepository;
    @Autowired
    private ShoesRepository shoesRepository;
    @Autowired
    private ClothesDeliveriesRepository clothesDeliveriesRepository;

    @GetMapping("/clotheslist")
    public String viewClothes(Model model){
        model.addAttribute("clothesList",clothesRepository.findAll());
        model.addAttribute("shoesList", shoesRepository.findAll());
        model.addAttribute("clothes", new Clothes());
        model.addAttribute("shoes", new Shoes());
        return "clothesforsale";
    }

    @PostMapping("/addclothes")
    public String addClothes(Clothes clothes){
        clothesRepository.save(clothes);
        return "redirect:/clotheslist";
    }

    @GetMapping("/deleteclothes/{id}")
    public String deleteClothes(@PathVariable("id") Integer id) {
        clothesRepository.deleteById(id);
        return "redirect:/clotheslist";
    }

    @GetMapping("/updateclothes/{id}")
    public String updateClothes(@PathVariable("id") Integer id, Model model) {
        Clothes clothes = clothesRepository.getById(id);
        model.addAttribute("clothesList",clothesRepository.findAll());
        model.addAttribute("clothes", clothes);
        return "editcloth";
    }
    @GetMapping("/sellclothes/{id}")
    public String sellClothes(@PathVariable("id") Integer id, Model model) {
        Clothes clothes = clothesRepository.getById(id);
        model.addAttribute("clothesList",clothesRepository.findAll());
        model.addAttribute("clothesDeliveriesList", clothesDeliveriesRepository.findAll());
        model.addAttribute("clothesDeliveries", new ClothesDeliveries());
        model.addAttribute("clothes", clothes);
        return "sellcloth";
    }
}
