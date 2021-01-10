package com.foodordering.app.controller;

import com.foodordering.app.dao.DishRepo;
import com.foodordering.app.entity.DishEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dish")
public class DishController {
    @Autowired
    DishRepo dishRepo;

    @GetMapping("/adddish")
    public String addDish(Model model){
        DishEntity dishEntity = new DishEntity();
        model.addAttribute("dish",dishEntity);
        return "Dish/Dish";
    }
    @PostMapping("/savedish")
    public String saveDish(DishEntity dishEntity){
        dishRepo.save(dishEntity);
        return "redirect:/";
    }

}
