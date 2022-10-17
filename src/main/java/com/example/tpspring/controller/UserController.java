package com.example.tpspring.controller;

import com.example.tpspring.controller.dto.CreateUser;
import com.example.tpspring.repository.entity.Users;
import com.example.tpspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("user",new CreateUser());
        return "signupForm";
    }

    @PostMapping("/signup")
    public String submitSignupForm(CreateUser createUser){
        userService.createUser(createUser);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }


    @GetMapping("/update")
    public String updateUser(Model model){
        model.addAttribute("user",CreateUser.fromUser(userService.findActualUser()));
        return "editUser";
    }

    @PostMapping("/update")
    public String submitUpdateUser(CreateUser createUser){
        userService.updateUser(createUser);
        return "redirect:/contact/home";
    }




}
