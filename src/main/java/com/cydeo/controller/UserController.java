package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user") //request mapping only class level
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")//endPoint
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());//communicate with the ui for empty form
        model.addAttribute("roles",roleService.findAll()); //bring me all roles from DB
        model.addAttribute("users",userService.findAll());

        return "/user/create"; //folder path for view
    }

    @PostMapping("/create")//endPoint
    public String insertUser(@ModelAttribute("user") UserDTO user){

       userService.save(user);


        return "redirect:/user/create"; //user,roles,users attirbute will be populated end of method
    }

    @GetMapping ("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){



        model.addAttribute("user",userService.findById(username));
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());

        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(UserDTO user){

        //how to update the map
        userService.update(user);

        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){

        //delete user
        userService.deleteById(username);

        return "redirect:/user/create";

    }
}
