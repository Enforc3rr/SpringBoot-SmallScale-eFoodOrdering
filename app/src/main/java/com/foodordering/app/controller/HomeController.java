package com.foodordering.app.controller;

import com.foodordering.app.entity.DishEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homeController(Model model){
        DishEntity dish1 = new DishEntity("null","null",0,"null");
        model.addAttribute("Dish",dish1);
        return "Home/Home.html";
    }
}
