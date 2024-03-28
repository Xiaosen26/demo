package com.xiaosen.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {

    @GetMapping("getname")
    public String getName(Model model){
        model.addAttribute("name","keafmd");
        return "name";
    }
//    @GetMapping("/login")
    public String Login(Model model){
        return "login";
    }
    @GetMapping("/getage")
    public String getAge(Model model){
        model.addAttribute("age",18);
        return "age";
    }
}
