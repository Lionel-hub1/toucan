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
public class ShoesController {
    @Autowired
    ShoesRepository shoesRepository;
    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired
    private ShoesDeliveriesRepository shoesDeliveriesRepository;

    @GetMapping("/shoeslist")
    public String viewShoes(Model model){
        model.addAttribute("shoesList",shoesRepository.findAll());
        model.addAttribute("clothesList",clothesRepository.findAll());
        model.addAttribute("clothes", new Clothes());
        model.addAttribute("shoes", new Shoes());
        return "shoesforsale";
    }

    @PostMapping("/addshoes")
    public String addShoes(Shoes shoes){
        shoesRepository.save(shoes);
        return "redirect:/shoeslist";
    }

    @GetMapping("/deleteshoes/{id}")
    public String deleteShoes(@PathVariable("id") Integer id) {
        shoesRepository.deleteById(id);
        return "redirect:/shoeslist";
    }

    @GetMapping("/updateshoes/{id}")
    public String updateShoes(@PathVariable("id") Integer id, Model model) {
        Shoes shoes = shoesRepository.getById(id);
        model.addAttribute("shoesList",shoesRepository.findAll());
        model.addAttribute("shoes", shoes);
        return "editshoe";
    }

    @GetMapping("/sellshoes/{id}")
    public String sellShoes(@PathVariable("id") Integer id, Model model) {
        Shoes shoes = shoesRepository.getById(id);
        model.addAttribute("shoesList",shoesRepository.findAll());
        model.addAttribute("shoesDeliveriesList", shoesDeliveriesRepository.findAll());
        model.addAttribute("shoes", shoes);
        model.addAttribute("shoesDeliveries", new ShoesDeliveries());
        return "sellshoe";
    }
}
