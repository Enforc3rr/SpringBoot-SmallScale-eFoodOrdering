package com.foodordering.app.controller;

import com.foodordering.app.dao.DishRepo;
import com.foodordering.app.dao.OrderRepo;
import com.foodordering.app.dao.UserRepo;
import com.foodordering.app.entity.DishEntity;
import com.foodordering.app.entity.OrderEntity;
import com.foodordering.app.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    private OrderEntity orderEntity;
    int totalCost = 0 ;
    @Autowired
    UserRepo userRepo;
    @Autowired
    DishRepo dishRepo;
    @Autowired
    OrderRepo orderRepo;

    @GetMapping("/menu")
    public String viewMenu(Model model){
        List<DishEntity> dishList = dishRepo.findAll();
        model.addAttribute("orderList" , dishList);
        return "Order/ViewMenu";
    }

    @GetMapping("/order")
    public String order(Model model){
        OrderEntity order = new OrderEntity();
        model.addAttribute("order",order);
        List<DishEntity> dishList = dishRepo.findAll();
        model.addAttribute("dishList",dishList);
        return "Order/AddOrder";
    }

    @PostMapping("/order/previeworder")
    public String previewOrder(OrderEntity orderEntity , Model model){
        List<DishEntity> dishEntityList = new ArrayList<>();

        for(int i = 0 ; i < orderEntity.getDishids().size() ; i++){
            dishEntityList.add(orderEntity.getDishids().get(i));
        }
        if(dishEntityList==null){
            DishEntity dishEntityNull = new DishEntity("null","null",0,"null");
            List<DishEntity> dishEntityListNull = new ArrayList<>();
            dishEntityListNull.add(dishEntityNull);
            model.addAttribute("preview",dishEntityListNull);
        }else {
            model.addAttribute("preview",dishEntityList);
            this.orderEntity = orderEntity;
        }

        for(int i = 0 ; i < orderEntity.getDishids().size() ; i++){
            totalCost = totalCost + orderEntity.getDishids().get(i).getDishCost();
        }

        model.addAttribute("total",totalCost);
        return "Order/PreviewOrder";
    }

    @GetMapping("/order/saveorder")
    public String saveOrder(Authentication authentication){
        UserEntity userEntityToBeStored = userRepo.findByUsername(authentication.getName());
        this.orderEntity.setUserid(userEntityToBeStored);
        this.orderEntity.setOrderCost(totalCost);
        totalCost = 0 ;
        orderRepo.save(this.orderEntity);
        return "redirect:/";
    }
}
