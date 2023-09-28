package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user") //request mapping only class level
public class UserController {

    @GetMapping("/create")//endPoint
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());
        //model.addAttribute("roles",LISTOFROLES)
        return "/user/create"; //folder path
    }
}
