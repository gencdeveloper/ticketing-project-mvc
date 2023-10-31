package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project") //request mapping only class level
public class ProjectController {

    @GetMapping("/create")//endPoint
    public String createUser(Model model){



        return "/project/create"; //folder path for view
    }
}
