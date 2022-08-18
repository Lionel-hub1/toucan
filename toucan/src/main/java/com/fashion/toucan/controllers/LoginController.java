package com.fashion.toucan.controllers;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.toucan.entities.Clothes;
import com.fashion.toucan.entities.Login;
import com.fashion.toucan.entities.Shoes;
import com.fashion.toucan.repositories.*;
import com.fashion.toucan.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService userService;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired
    private ShoesRepository shoesRepository;
    @Autowired
    private ClothesDeliveriesRepository clothesDeliveriesRepository;
    @Autowired
    private ShoesDeliveriesRepository shoesDeliveriesRepository;

    @GetMapping("/home")
    public String viewHome(Model model){
        model.addAttribute("clothesList",clothesRepository.findAll());
        model.addAttribute("shoesList", shoesRepository.findAll());
        model.addAttribute("clothesDeliveriesList", clothesDeliveriesRepository.findAll());
        model.addAttribute("shoesDeliveriesList", shoesDeliveriesRepository.findAll());
        model.addAttribute("clothes", new Clothes());
        model.addAttribute("shoes", new Shoes());
        return "home";
    }

    @PostMapping("/addLoginInfo")
    public String addSLoginInfo(Login user){
        loginRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/")
    public ModelAndView login(Model model) {
        model.addAttribute("usersList", loginRepository.findAll());
        model.addAttribute("user", new Login());
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {
        Login oauthUser = userService.login(user.getUsername(), user.getPassword());
        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            return "redirect:/home";
        }
        else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/";
    }
}