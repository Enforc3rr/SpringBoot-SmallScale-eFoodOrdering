package com.foodordering.app.controller;

import com.foodordering.app.dao.UserRepo;
import com.foodordering.app.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String userSignup(Model model){
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user",userEntity);
        return "User/UserSignup";
    }
    @PostMapping("/saveuser")
    public String userSave(UserEntity userEntity){
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userRepo.save(userEntity);
        return "redirect:/";
    }
}
